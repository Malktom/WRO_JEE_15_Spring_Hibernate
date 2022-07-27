package pl.coderslab.encje;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.encje.model.*;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @GetMapping("/bookswithpublishers")
    @ResponseBody
    public String booksWithPublishers() {
        bookDao.findBooksWithPublisher()
                .forEach(b-> System.out.println(b.getTitle()));
        return "books with publishers:";
    }
    @GetMapping("/bookByPub")
    @ResponseBody
    public String booksByPub(@RequestParam Long pubId) {
        bookDao.findAllbyPublisher(publisherDao.getPublisherById(pubId))
                .forEach(b-> System.out.println(b.getTitle()));
        return "books by publisher Id:";
    }

    @GetMapping("/bookByAuthor")
    @ResponseBody
    public String booksByAuthor(@RequestParam Long authorId) {
        bookDao.findByAuthor(authorDao.getAuthorById(authorId))
                .forEach(b-> System.out.println(b.getTitle()));
        return "books by author Id:";
    }


    @GetMapping("/test-rating")
    @ResponseBody
    public String testRatinig(@RequestParam int rating) {
        bookDao.findAllbyRating(rating)
                .forEach(b-> System.out.println(b.getTitle()));
        return "test-rating:";
    }
    @GetMapping("/allpublishers")
    @ResponseBody
    public String showAllPublishers() {
        publisherDao.findAll()
                .forEach(b-> System.out.println(b.getName()));
        return "all publishers:";
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
