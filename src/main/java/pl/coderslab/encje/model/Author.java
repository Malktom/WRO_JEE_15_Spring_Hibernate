package pl.coderslab.encje.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
//    @ManyToMany(mappedBy = "authors")
//    private List<Book> book;


    @Override
    public String toString() {
        return this.firstName + " "+ this.lastName;
    }
}
