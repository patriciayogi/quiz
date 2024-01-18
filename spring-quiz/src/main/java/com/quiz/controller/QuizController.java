package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuestionService;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/quiz")
    public Quiz generateQuiz(@RequestParam(name = "category", defaultValue = "java") String category) throws IOException, InterruptedException {
        return quizService.findQuestions();
    }

    @PostMapping(value = "/load")
    public Quiz loadQuestions() {
        return questionService.loadQuestions();
    }

}
