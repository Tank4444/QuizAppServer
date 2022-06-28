package ru.chuikov.entity.quiz;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.actor.Player;
import ru.chuikov.entity.actor.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "GAME")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Game {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "ACCOUNT_ID", nullable = false)
        private User creator;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
        private List<Player> player;

        @Column(name = "game_type")
        @Enumerated(EnumType.STRING)
        private GameType gameType;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
        @JsonManagedReference
        private List<Question> questions;
}