package pl.coderslab.dwarfs;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository // @Component
@Transactional   // musimy dodac, bo w AppConfig transactionManager tego wymaga
public class DwarfDao {

    @PersistenceContext // wtedy nie trzeba konstruktora
    private EntityManager entityManager;

    public void save(Dwarf dwarf) {
        entityManager.persist(dwarf);  // metoda do zapisania krasnala do DB
    }

    public Dwarf findById(Long id) {

        return entityManager.find(Dwarf.class,id);
    }

    public  void update(Dwarf dwarf) {
        entityManager.merge(dwarf);
    }

    public  void delete(Dwarf dwarf) {
        entityManager.remove(entityManager.contains(dwarf) ?
                dwarf:entityManager.merge(dwarf));
    }
}
