package pl.coderslab.student1;


import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;
    private String lastName;
    private List<String> hobbies;
    @Override
    public String toString() {
        return "Student [firstName=" + firstName +
                ",lastName=" + lastName + "]";
    }
}