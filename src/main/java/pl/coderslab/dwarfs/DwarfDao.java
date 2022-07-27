package pl.coderslab.dwarfs;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository // @Component
@Transactional   // musimy dodac, bo w AppConfig transactionManager tego wymaga
public class DwarfDao {

    @PersistenceContext // wtedy nie trzeba konstruktora
    private EntityManager entityManager;

    public List<Dwarf> findAll() {
        Query query = entityManager.createQuery("select d from Dwarf d ");
        List<Dwarf> resultList = query.getResultList();
        return resultList;
    }

        public List<Dwarf> findAllSecond() {
        return entityManager.createQuery("select d from Dwarf d ")
                .getResultList();

    }

    public void save(Dwarf dwarf) {
        entityManager.persist(dwarf);  // metoda do zapisania krasnala do DB
    }

    public Dwarf findById(Long id) {

        return entityManager.find(Dwarf.class, id);
    }

    public void update(Dwarf dwarf) {
        entityManager.merge(dwarf);
    }

    public void delete(Dwarf dwarf) {
        entityManager.remove(entityManager.contains(dwarf) ?
                dwarf : entityManager.merge(dwarf));
    }
}
