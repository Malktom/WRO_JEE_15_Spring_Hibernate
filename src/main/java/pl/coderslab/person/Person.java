package pl.coderslab.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne
    @JoinColumn(name="details_id", unique = true)
    private PersonDetails details;

//    @OneToOne
//    private PersonDetails personDetails;
}

