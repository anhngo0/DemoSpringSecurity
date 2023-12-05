package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<ApplicationUser> findByEmail(String email);
}
