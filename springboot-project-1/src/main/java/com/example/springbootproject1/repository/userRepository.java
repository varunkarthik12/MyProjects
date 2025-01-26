package com.example.springbootproject1.repository;

import com.example.springbootproject1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface userRepository  extends JpaRepository<User,Long> {

     Optional<User> findByFirstName(String firstName);

     List<User> findByCompanyContaining(String company);

     Optional<User> findByEmail(String email);
}
