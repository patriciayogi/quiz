package com.quiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String questionText;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "question_options",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "ID")}
    )
    private List<Options> options;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "correct_option_id")
    private Options correctOption;

    private String explanation;

}