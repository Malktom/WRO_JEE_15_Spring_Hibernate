package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/add")
    public String add (Model model) {
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @GetMapping("/list")
    public String list (Model model) {
        model.addAttribute("person", personDao.findAll());
        return "list";
    }
//    @PostMapping("/add")   // ponizej prosciej
//    public String save (@RequestParam String login,
//                        @RequestParam String password,
//                        @RequestParam String email) {
//        Person person = new Person();
//        person.setEmail(email);
//        person.setPassword(password);
//        person.setLogin(login);
//        personDao.save(person);
//        return "person/add";
//    }

    @PostMapping("/add") //bindowanie formularza do obiektów "form"
    public String save (Person person) {
        personDao.save(person);
        return "redirect:/person/list";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam long id) {
        personDao.delete(personDao.findById(id));
        return "redirect:/person/list";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String savePerson() {
        Person person = new Person();
        person.setLogin("Technomate");
        personDao.save(person);
        return "ok";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable Long id) {
        Person byId = personDao.findById(id);
        System.out.println(byId.getLogin());
        return byId.getId() + " , " +
                byId.getLogin();
    }

    @RequestMapping("/update/{id}/{password}")
    @ResponseBody
    public String updatePerson(@PathVariable Long id, @PathVariable String password) {
        Person byId = personDao.findById(id);
        byId.setPassword(password);
        personDao.update(byId);
        return "Person updated";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable Long id) {
        Person byId = personDao.findById(id);
        personDao.delete(byId);
        return "Person deleted";
    }
}
