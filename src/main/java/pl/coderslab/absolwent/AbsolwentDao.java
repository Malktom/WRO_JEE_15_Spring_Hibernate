package pl.coderslab.absolwent;

import org.springframework.stereotype.Repository;
import pl.coderslab.encje.model.Book;
import pl.coderslab.person.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional // musi byc bo error "No EntityManager with actual transaction available for current th"
public class AbsolwentDao {
    @PersistenceContext // wtedy nie trzeba konstruktora
    private EntityManager entityManager;

    public List<Book> findAll() {
        return entityManager.createQuery("select b from Absolwent b").getResultList();

    }

    public void save(Absolwent absolwent) {
        entityManager.persist(absolwent);
    }

    public void update(Absolwent absolwent) {
        entityManager.merge(absolwent);
    }

    public Absolwent getAbsolwentById(long id) {

        return entityManager.find(Absolwent.class, id);

    }

    public void delete(Absolwent absolwent) {
        entityManager.remove(entityManager.contains(absolwent) ?
                absolwent : entityManager.merge(absolwent));
    }
}