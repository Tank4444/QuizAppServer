package ru.chuikov.entity;


import javax.persistence.*;

@Entity
@Table(name = "AR")
public class AR {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AR_TYPE_ID", nullable = false)
    ARType arType;

    @Column
    String hint;

    @OneToOne(optional = false, mappedBy="ar")
    File target;

    @OneToOne(optional = false, mappedBy="ar")
    File object;

}
