package ru.chuikov.entity;


import javax.persistence.*;

@Entity
@Table(name = "FILE")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    byte[] bytes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    User creator;

    @Column
    String meta;


    @OneToOne(optional = false)
    @JoinColumn(name = "ar_id",unique = false, nullable = true, updatable = true)
    AR ar;

}
