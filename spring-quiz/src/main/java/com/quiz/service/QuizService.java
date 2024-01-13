package com.quiz.service;

import com.quiz.model.Question;
import com.quiz.model.Quiz;
import com.quiz.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository quizRepository;
    private static final Logger LOG = LoggerFactory.getLogger(QuizService.class);

    public Quiz findQuestions() {
        Iterable<Question> questions = quizRepository.findAll();
        return Quiz.builder().questions(StreamSupport.stream(questions.spliterator(), false)
                .collect(Collectors.toList())).build();
    }

}
