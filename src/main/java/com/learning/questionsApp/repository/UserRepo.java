package com.learning.questionsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.questionsApp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
