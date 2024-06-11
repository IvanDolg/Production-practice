package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
