package ru.chuikov.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "APP_ID", nullable = false)
    Game game;

    @Column
    String name;

    @Column
    Date timeStart;

    @Column
    Date timeEnd;

    @Column
    int score;

}
