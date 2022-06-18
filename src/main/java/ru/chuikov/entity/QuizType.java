package ru.chuikov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "QUIZ_TYPE")
public class QuizType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quizType")
    List<Quiz> quizzes;
}
