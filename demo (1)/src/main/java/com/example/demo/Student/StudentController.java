package com.example.demo.Student;

import com.example.demo.Student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private List<Student> listStudent = List.of(
            new Student(
                    1,"Johan", 18, "johan18@gmail.com"
            ),
            new Student(2, "tenma", 28, "tenmaDr@gmail.com")
    );
    @GetMapping(path = "{studentId}")
    public Student getSpecifiedStudent(@PathVariable("studentId") int studentId){
        return listStudent.stream()
                .filter(student -> student.getStudentId() == studentId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("student having "+ studentId+"id is not exist"));
    }
/*
    @GetMapping()
    public Student getAllStudent(){
        return StudentService.getAllStudent();
    }*/
}
