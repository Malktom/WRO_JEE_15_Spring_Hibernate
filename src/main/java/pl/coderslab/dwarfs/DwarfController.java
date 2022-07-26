package pl.coderslab.dwarfs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dwarf")
public class DwarfController {

    //    private final DwarfDao dwarfDao;
//
//    public DwarfController(DwarfDao dwarfDao) {
//        this.dwarfDao = dwarfDao;
//    }
    private final DwarfService dwarfService;

    public DwarfController(DwarfService dwarfService) {
        this.dwarfService = dwarfService;
    }




    @GetMapping("all")
    @ResponseBody
    public String showAl() {
        dwarfService.findAll()
               .forEach(d-> System.out.println(d.getName()));


        return "list";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String saveDwarf() {
        Dwarf dwarf = new Dwarf();
        dwarf.setName("Konstruktor");
        dwarf.prePersist();
        dwarfService.save(dwarf);
        return "ok";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getDwarf(@PathVariable Long id) {
        Dwarf byId = dwarfService.findById(id);
        System.out.println(byId.getName());
        return "dwarf:" + byId.getName();
    }
}
