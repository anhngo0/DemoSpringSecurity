package com.example.demo.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

/*@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name = "_user")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int studentId;
    private String studentName;
    private int age;
    private String email;

    public Student(int studentId,String studentName, int age, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString(){
        return "{" +
                "id:"+ studentId+
                "name:" + studentName+
                "email:" + email+
                "age:" + age+
                "}";
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
