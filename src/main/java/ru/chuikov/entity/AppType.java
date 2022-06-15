package ru.chuikov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "APP_TYPE")
class AppType {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @Column
        String name;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "appType")
        List<App> apps;
}