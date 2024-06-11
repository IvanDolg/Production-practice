package com.progtammingtechie.productionpractice.controller;

import com.progtammingtechie.productionpractice.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student strudent = new Student();

        strudent.setId(1);
        strudent.setFirstName("Ivan");
        strudent.setLastName("Dolgolaptev");

        return ResponseEntity.ok(strudent);
    }


    @GetMapping("/listStudents")
    public ResponseEntity<List<Student>> getListStudents() {
        List<Student> students = List.of(
                new Student(1, "Ivan", "Dolgolaptev"),
                new Student(2, "Petr", "Petrov"),
                new Student(3, "Sidor", "Sidorov")
        );

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int studentId,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new  ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Student " + studentId + " was deleted");
    }
}
