package ru.chuikov.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AR_TYPE")
public class ARType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arType")
    List<AR> arList;
}
