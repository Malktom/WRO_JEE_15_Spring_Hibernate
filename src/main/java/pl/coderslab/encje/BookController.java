package pl.coderslab.encje;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.encje.model.Book;
import pl.coderslab.encje.model.BookDao;
import pl.coderslab.encje.model.Publisher;
import pl.coderslab.encje.model.PublisherDao;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }


    @RequestMapping("/create")
    @ResponseBody
    public String saveBook() {
        Book build = Book.builder().title("Thinking in java")
                .rating(4)
                .description("Baout java")
                .build();
        bookDao.save(build);
        return "ok";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getDwarf(@PathVariable Long id) {
        Book byId = bookDao.getBookById(id);

        System.out.println(byId.getTitle());

        return "Book: " + byId.getTitle();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteBook(Book book) {
        bookDao.delete(book);

        return "book deleted";
    }

    @RequestMapping("/update/{id}/{rating}")
    @ResponseBody
    public String updated(@PathVariable Long id,
                          @PathVariable int rating) {
        Book byId = bookDao.getBookById(id);
        byId.setRating(rating);
        byId.setTitle("New title");
        bookDao.update(byId);
        return "updated";
    }


    @RequestMapping("/save-publisher-book")
    @ResponseBody
    public String savePublisherBook() {
       Publisher publisher = new Publisher();
        publisher.setName("Helion");

        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Some title");
        book.setPublisher(publisher);
        bookDao.save(book);
        return " publisher saved";
    }
    @RequestMapping("/get-publishers/{id1}/{id2}")
    @ResponseBody
    public String savePublisherBook( @PathVariable Long id1,
                                     @PathVariable Long id2) {

        System.out.println(publisherDao.getPublisherById(id1).getName());
        System.out.println(publisherDao.getPublisherById(id2).getName());

        return "publishers";
    }
}
