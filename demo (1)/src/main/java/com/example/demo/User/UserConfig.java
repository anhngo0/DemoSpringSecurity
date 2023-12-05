package com.example.demo.User;

import com.example.demo.Security.PasswordConfig;
import com.example.demo.Student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static com.example.demo.Security.ApplicationUserRole.ADMIN;
import static com.example.demo.Security.ApplicationUserRole.STUDENT;

@Configuration
public class UserConfig {
    PasswordEncoder passwordEncoder;
    List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = List.of(
                new ApplicationUser(
                        STUDENT.getGrantedAuthority(),
                        passwordEncoder.encode("password1"),
                        "johanLiebert",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthority(),
                        passwordEncoder.encode("password2"),
                        "annaLiebert",
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;
    }
}
