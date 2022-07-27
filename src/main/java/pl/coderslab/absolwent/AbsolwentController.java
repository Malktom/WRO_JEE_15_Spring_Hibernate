package pl.coderslab.absolwent;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dwarfs.DwarfService;
import pl.coderslab.person.Person;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/absolwent")
public class AbsolwentController {

    private final AbsolwentDao absolwentDao;
    public AbsolwentController (AbsolwentDao absolwentDao) {
        this.absolwentDao=absolwentDao;
    }
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")   // sprawdzic jaki jest w widoku .jsp
    public List<String> skills() {
        String[] skills = new String[]{"java", "php", "ruby", "python"};
        return Arrays.asList(skills);

    }
    @ModelAttribute("hobbies")   // sprawdzic jaki jest w widoku .jsp
    public List<String> hobbies() {
        String[] hobbies = new String[]{"music", "movies", "rugby", "travel"};
        return Arrays.asList(hobbies);

    }

    @GetMapping("/add")
    public String add (Model model) {
        model.addAttribute("absolwent", new Absolwent());
        return "addAbsolwent";
    }
    @PostMapping("/add") //bindowanie formularza do obiektów "form"
    public String save (Absolwent absolwent) {
        absolwentDao.save(absolwent);
        return "redirect:/absolwent/add";
    }

}
