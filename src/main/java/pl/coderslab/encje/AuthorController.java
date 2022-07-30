package pl.coderslab.encje;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.encje.model.Author;
import pl.coderslab.encje.model.AuthorDao;
import pl.coderslab.person.Person;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorDao authorDao;


    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("list")
    public String showAllAuthors(Model model){
        model.addAttribute("authors",authorDao.findAll());

        return "authorsList";
    }
    @GetMapping("addAuthor")

    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }
    @PostMapping("addAuthor")
    public String save(Author author) {
        authorDao.save(author);
        return "redirect:/author/list";
    }

    @RequestMapping("/delete/{id}")

    public String deletePerson(@PathVariable Long id) {
        Author byId = authorDao.findById(id);
        authorDao.delete(byId);
        return "redirect:/author/list";
    }

    @GetMapping("/edit/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {
        Author byId = authorDao.findById(id);
        model.addAttribute("author", byId);
        return "editAuthor";

    }
    @PostMapping("/edit/{id}")   // {id}?????
    public String edit(Author author) {
        authorDao.update(author);
        return "redirect:/author/list";
    }

}
