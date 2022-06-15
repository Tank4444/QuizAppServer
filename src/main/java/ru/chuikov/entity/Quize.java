package ru.chuikov.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "QUIZE")
class Quize {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

}