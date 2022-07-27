package pl.coderslab.encje.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext // wtedy nie treba konstruktora
    private EntityManager entityManager;

    public List<Book> findAll(){
        return entityManager.createQuery("select b from Book b").getResultList();

    }
    public List<Book> findAllbyRating (int rating){
        return entityManager.createQuery("select b from Book b where " +
                "b.rating=:score").setParameter("score",rating).getResultList();

    }

    public List<Book> findBooksWithPublisher(){
        return entityManager.createQuery("select b from Book b join b.publisher").getResultList();

    }
    public List<Book> findAllbyPublisher (Publisher publisher){
        return entityManager.createQuery("select b from Book b where b.publisher=:pubId").setParameter("pubId",publisher)
                .getResultList();


    }
    public List<Book> findByAuthor (Author author){
        return entityManager.createQuery("select distinct b from Book b join FETCH b.authors WHERE :author member of b.authors").setParameter("author",author)
                .getResultList();


    }


    public void save(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book getBookById(long id) {

        return entityManager.find(Book.class, id);

    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }


}
