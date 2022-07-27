package pl.coderslab.absolwent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "absolwent")
public class Absolwent {

    @Id                                                         // ID musi byc aby stworzyc tabele w DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    @Transient
    private List<String> programmingSkills;
    @Transient
    private List<String> hobbies;

}
