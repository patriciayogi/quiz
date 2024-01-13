package com.quiz.service;

import com.quiz.model.Options;
import com.quiz.model.Question;
import com.quiz.model.Quiz;
import com.quiz.repository.OptionRepository;
import com.quiz.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository quizRepository;
    @Autowired
    private OptionRepository optionRepository;

    private static final Logger LOG = LoggerFactory.getLogger(QuestionService.class);

    public Quiz loadQuestions() {
        List<Question> questions = createQuestions();

        quizRepository.saveAll(questions);
        Quiz quiz = Quiz.builder().questions(questions).build();
        return quiz;
    }

    private List<Question> createQuestions() {

        List<Question> questions = new ArrayList<>();
        questions.add(toQuestion("What is class variable?", "",
                Arrays.asList("class variables are static variables within a class but outside any method.",
                        "class variables are variables defined inside methods, constructors or blocks.",
                        "class variables are variables within a class but outside any method.",
                        "None of the above."), 0));

        questions.add(toQuestion("If a method does not access instance variables, it can be declared as...?",
                "If a method does not access instance variables, it can be declared as static. This means the method belongs to the class, not any specific instance of the class.",
                Arrays.asList("void",
                        "public",
                        "private",
                        "static"), 3));

        questions.add(toQuestion("What is method overloading in Java?",
                "Having multiple methods with the same name but different parameters in a class.",
                Arrays.asList("Calling a method from another method.",
                        "Renaming a method at runtime.",
                        "Having multiple methods with the same name but different parameters in a class.",
                        "Overriding a superclass method in a subclass."), 2));

        questions.add(toQuestion("What is the purpose of the Stream API in Java 8?",
                "The Stream API in Java 8 provides a functional programming-style approach to manipulate collections of data, enabling operations like filtering, mapping, and reducing. ",
                Arrays.asList("To perform I/O operations on files and directories",
                        "To enable concurrent programming",
                        "To manipulate collections of data in a functional style",
                        "To handle exceptions in a functional programming paradigm"), 2));

        questions.add(toQuestion("A functional interface",
                "An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class",
                Arrays.asList("can have any number of default, static methods but can contain only one abstract method",
                        "can have any number of abstract, static methods but can contain only one default method",
                        "can have any number of default, abstract methods but can contain only exactly only one static method",
                        "it can have any number of abstract, static methods."), 0));

        questions.add(toQuestion("What is the main advantage of using parallel streams in Java 8?",
                "Using parallel streams in Java 8 allows for concurrent execution of operations on multiple threads, potentially speeding up processing for large datasets. ",
                Arrays.asList("Faster execution of sequential operations ",
                        "Improved memory utilization ",
                        "Automatic handling of exceptions ",
                        "Concurrent execution on multiple threads "), 3));

        questions.add(toQuestion("Which one of the following abstract methods does not take any argument but returns a value?",
                "The signature of get() method in java.util.function.Supplier  interface is: T get().",
                Arrays.asList("The accept() method in java.util.function.Consumer interface",
                        "The get() method in java.util.function.Supplier interface",
                        "The test() method in java.util.function.Predicate interface",
                        "The apply() method in java.util.function.Function interface"), 1));

        questions.add(toQuestion("Which of the following are short-circuit operations?",
                "findFirst is the only short-circuit operation. reduce is a terminal operation. the parallel is an intermediate operation. findNone doesn't exist.",
                Arrays.asList("reduce",
                        "parallel",
                        "findNone",
                        "findFirst"), 3));

        return questions;
    }

    private Question toQuestion(String question, String explanation, List<String> options, int index) {
        List<Options> optionList = createOptions(options);
        return Question.builder().questionText(question)
                .explanation(explanation)
                .correctOption(optionList.get(index))
                .options(optionList)
                .build();
    }

    private List<Options> createOptions(List<String> options) {
        List<Options> optionList = new ArrayList<>();
        for (String option : options) {
            optionList.add(Options.builder().description(option).build());
        }
        optionRepository.saveAll(optionList);
        return optionList;
    }
}
