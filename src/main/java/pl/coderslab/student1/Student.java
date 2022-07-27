package pl.coderslab.student1;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Student [firstName=" + firstName +
                ",lastName=" + lastName + "]";
    }
}