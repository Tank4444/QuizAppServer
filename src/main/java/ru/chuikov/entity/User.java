package ru.chuikov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ACCOUNT")
class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        @Column
        String email;
        @Column
        String password;
        @Column
        String first_name;
        @Column
        String last_name;
        @Column
        String org_name;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
        List<Game> games;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
        List<File> files;

}