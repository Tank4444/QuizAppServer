package ru.chuikov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "APP")
public class App {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "ACCOUNT_ID", nullable = false)
        User user;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "app")
        List<Player> player;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "APP_TYPE_ID", nullable = false)
        AppType appType;


        @OneToMany(fetch = FetchType.LAZY, mappedBy = "app")
        List<Question> questions;
}