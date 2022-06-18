package ru.chuikov.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "QUESTION")
class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "APP_ID", nullable = false)
    Game game;




}