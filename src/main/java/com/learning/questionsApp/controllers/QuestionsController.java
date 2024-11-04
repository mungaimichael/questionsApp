package com.learning.questionsApp.controllers;

import com.learning.questionsApp.entity.Question;
import com.learning.questionsApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")

    public List<Question> getAllQuestions () {
        return questionService.getAllQuestions();
    }




}