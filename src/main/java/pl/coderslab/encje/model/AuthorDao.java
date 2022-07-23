package pl.coderslab.encje.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author){
        entityManager.persist(author);
    }

    public void update(Author author){
        entityManager.merge(author);
    }

    public Author findById(Long id){
        return  entityManager.find(Author.class,id);
    }

    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }
}