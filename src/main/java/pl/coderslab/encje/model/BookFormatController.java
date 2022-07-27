package pl.coderslab.encje.model;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bookFormat")
public class BookFormatController {

    private BookDao bookDao;
    private PublisherDao publisherDao;

    public BookFormatController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao=publisherDao;
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "list";
    }
    @GetMapping("/addBook")
    public String addBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("publishers", publisherDao.findAll());
        return "addBook";

    }
    @PostMapping("/addBook")

    public String saveBook(Book book, Model model) {
        bookDao.save(book);
        return "list";
    }
}
