package com.learning.questionsApp.services;

import com.learning.questionsApp.entity.Question;
import com.learning.questionsApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

   public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public Optional<Question> getSingleQuestion (int id) {
       return questionRepo.findById(id);
    }

    public  String createQuestion(Question question) {
       questionRepo.save(question);
       return "Question created";
    }

    // delete question from db
    public String deleteQuestion(int id) {

        if (questionRepo.existsById(id)) { // Check if the question exists
            questionRepo.deleteById(id);
            return "Question deleted";
        } else {
            return "Question not found";
        }
    }

    public String updateQuestion(Question question) {
       // check if question exits then edit the fields
       if (questionRepo.existsById(question.getId())) {
           questionRepo.save(question);
       }
       return "Question updated";
    }

}
