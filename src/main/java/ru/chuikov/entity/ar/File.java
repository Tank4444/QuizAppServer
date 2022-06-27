package ru.chuikov.entity.ar;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.actor.User;
import ru.chuikov.entity.ar.AR;

import javax.persistence.*;

@Entity
@Table(name = "FILE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @Lob
    @Column(columnDefinition="BLOB")
    byte[] bytes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @JsonIgnore
    User creator;

    @Column
    String meta;


    @OneToOne(optional = true)
    @JoinColumn(name = "ar_id")
    AR ar;

}
