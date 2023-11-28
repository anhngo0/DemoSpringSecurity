package com.example.demo.Student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagement {
    private static  final List<Student> STUDENT = Arrays.asList(
            new Student(
                    1,"Johan", 18, "johan18@gmail.com"
            ),
            new Student(2, "tenma", 28, "tenmaDr@gmail.com"),
            new Student(3, "anna", 18, "annaLie@gmail.com")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
    public List<Student> getAllStudent(){
        return STUDENT;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registeredNewStudent(@RequestBody Student student){
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student){
        System.out.println(String.format("%s %s", studentId, student));
    }
}
