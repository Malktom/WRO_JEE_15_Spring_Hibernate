package pl.coderslab.encje.model;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookForm")
public class BookFormController {

    private BookDao bookDao;
    private PublisherDao publisherDao;
    private AuthorDao authorDao;
    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao=publisherDao;
        this.authorDao=authorDao;
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "booksList";
    }
    @GetMapping("/addBook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        return "addBook";

    }
    @PostMapping("/addBook")
    @ResponseBody
    public String saveBook(Book book) {
        bookDao.save(book);
        return "list updated";
    }
}
