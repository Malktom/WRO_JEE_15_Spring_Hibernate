package pl.coderslab.encje.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors;




}