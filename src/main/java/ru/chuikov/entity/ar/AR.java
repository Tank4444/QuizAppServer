package ru.chuikov.entity.ar;


import javax.persistence.*;

@Entity
@Table(name = "AR")
public class AR {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    ArType arType;

    @Column
    String hint;

    @OneToOne(optional = false, mappedBy="ar")
    File target;

    @OneToOne(optional = false, mappedBy="ar")
    File object;

}
