package com.learning.questionsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String questionTitle;

    @ElementCollection
    private List<String> questionOptions;

    private String difficultyLevel;

    private String correctAnswer;
}