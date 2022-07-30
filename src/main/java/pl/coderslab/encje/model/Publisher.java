package pl.coderslab.encje.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="publshers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisher") // dwukierunkowa relacja
    private List<Book> books=new ArrayList<>();

    @Override
    public String toString() {
        return this.name;
    }
}

