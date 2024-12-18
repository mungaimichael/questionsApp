package com.learning.questionsApp.repository;

import com.learning.questionsApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  QuestionRepo extends JpaRepository<Question, Integer> {

}
