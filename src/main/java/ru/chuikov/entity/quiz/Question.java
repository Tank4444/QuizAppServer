package ru.chuikov.entity.quiz;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUESTION")
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @Column
        String text;

        @Column(name = "question_type")
        @Enumerated(EnumType.STRING)
        QuestionType questionType;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
        List<Answer> answers;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "GAME_ID")
        Game game;

}