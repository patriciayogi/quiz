package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuestionService;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/load")
    public Quiz loadQuestions(@RequestParam(name = "category", defaultValue = "java") String category) throws IOException, InterruptedException {
        return questionService.loadQuestions();
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
