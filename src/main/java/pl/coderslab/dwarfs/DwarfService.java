package pl.coderslab.dwarfs;


import org.springframework.stereotype.Service;

import java.util.List;

@Service   // serwisy skupiaja wiele repozytoriow ( np klasy dao)
public class DwarfService {

    private final DwarfDao dwarfDao;
    public DwarfService (DwarfDao dwarfDao) {
    this.dwarfDao = dwarfDao;
    }

    public void save (Dwarf dwarf) {

        dwarfDao.save(dwarf);
    }
    public Dwarf findById(Long id) {
        return dwarfDao.findById(id);
    }

    public List<Dwarf> findAll() {
        return dwarfDao.findAllSecond();
    }
}