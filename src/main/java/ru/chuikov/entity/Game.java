package ru.chuikov.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APP")
public class Game {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "ACCOUNT_ID", nullable = false)
        User creator;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
        List<Player> player;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "APP_TYPE_ID", nullable = false)
        GameType gameType;


        @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
        List<Question> questions;
}