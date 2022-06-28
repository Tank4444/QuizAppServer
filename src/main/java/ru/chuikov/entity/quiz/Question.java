package ru.chuikov.entity.quiz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "QUESTION")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column
        private String text;

        @Column(name = "question_type")
        @Enumerated(EnumType.STRING)
        private QuestionType questionType;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
        @JsonManagedReference
        private List<Answer> answers;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "GAME_ID")
        @JsonBackReference
        private Game game;

}