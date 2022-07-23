package pl.coderslab.encje.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext // wtedy nie treba konstruktora
    private EntityManager entityManager;

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
