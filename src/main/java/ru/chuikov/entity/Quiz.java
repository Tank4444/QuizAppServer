package ru.chuikov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "QUIZ")
class Quiz {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @Column
        String text;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "QUIZ_TYPE_ID", nullable = false)
        QuizType quizType;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
        List<Answer> answers;

}