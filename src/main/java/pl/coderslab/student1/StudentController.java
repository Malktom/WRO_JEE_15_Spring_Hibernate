package pl.coderslab.student1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }
    @ModelAttribute("hobbies")
    public List<String> hobbiesOptions() {
        String[] a = new String[] {"music", "cinema", "rugby", "books"};
        return Arrays.asList(a);
    }
    @GetMapping("/add")
    public String add(Model model){
        Student student = new Student();
        student.setFirstName("Adam");
        student.setLastName("Kowalski");
        model.addAttribute("student", student);
        model.addAttribute("languages ", Arrays.asList(new String[]{"java", "php", "ruby", "python"}));

        return "form";
    }

    @PostMapping("/add")
    public String save(Student student, Model model){
        System.out.println(student.toString());
        model.addAttribute("student",student);
        return"save";
    }

}
