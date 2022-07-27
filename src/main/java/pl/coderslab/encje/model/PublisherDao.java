package pl.coderslab.encje.model;

import org.springframework.stereotype.Repository;
import pl.coderslab.dwarfs.Dwarf;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository // @Component
@Transactional
public class PublisherDao {

    @PersistenceContext // wtedy nie trzeba konstruktora
    private EntityManager entityManager;

    public List<Publisher> findAll() {
       return entityManager.createQuery("select d from Publisher d ").getResultList();

    }

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher getPublisherById(long id) {
        return entityManager.find(Publisher.class, id);

    }

    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }


}
