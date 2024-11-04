package com.learning.questionsApp.services;

import com.learning.questionsApp.entity.Question;
import com.learning.questionsApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

   public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
}
