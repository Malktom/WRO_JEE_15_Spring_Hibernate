package pl.coderslab.dwarfs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter  // @Data troche niebezpieczna, bo zawiera np toString() zawierjaaca wszystkie pola
@Setter
@Table(name = "dwarfs")
public class Dwarf {
    @Id                                                         // ID musi byc aby stworzyc tabele w DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "latitude")
    private String lat;
    private String lng;
    private String street;
    private String nearestNumber;
    @Transient
    private long distanceFromPapa;
    @Transient
    private LocalDateTime createdOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }
}