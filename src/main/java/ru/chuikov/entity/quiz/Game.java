package ru.chuikov.entity.quiz;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.chuikov.entity.actor.Player;
import ru.chuikov.entity.actor.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GAME")
public class Game {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "ACCOUNT_ID", nullable = false)
        @JsonIgnore
        User creator;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
        List<Player> player;

        @Column(name = "game_type")
        @Enumerated(EnumType.STRING)
        GameType gameType;


        @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
        List<Question> questions;
}