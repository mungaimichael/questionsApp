package com.learning.questionsApp.controllers;

import com.learning.questionsApp.entity.Question;
import com.learning.questionsApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/question")
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Get a single question
    @GetMapping("/questions/{id}")
    public Optional<Question> getSingleQuestion(@PathVariable int id) {
        return questionService.getSingleQuestion(id);
    }

    // POST controller for user to add a custom question to db
    @PostMapping("/create")
    public String createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    //  DELETE mapping
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

    // Edit a question
    @PutMapping("edit/{id}")
    public String updateQuestion(@PathVariable int id, @RequestBody Question question) {
        return questionService.updateQuestion(question);
    }
}
