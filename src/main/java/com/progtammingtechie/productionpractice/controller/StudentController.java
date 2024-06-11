package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent() {
        Student strudent = new Student();

        strudent.setId(1);
        strudent.setFirstName("Ivan");
        strudent.setLastName("Dolgolaptev");

        return strudent;
    }


    @GetMapping("/listStudents")
    public List<Student> getListStudents() {
        List<Student> students = List.of(
                new Student(1, "Ivan", "Dolgolaptev"),
                new Student(2, "Petr", "Petrov"),
                new Student(3, "Sidor", "Sidorov")
        );

        return students;
    }
}
