package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student getStudentById(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int studentId,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
