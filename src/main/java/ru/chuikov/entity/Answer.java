package ru.chuikov.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String text;

    @Column
    Boolean isRight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "QUIZ_ID", nullable = false)
    Quiz quiz;
}
