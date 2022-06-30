package ru.chuikov.entity.dto.actor;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.dto.quiz.GameDto;
import ru.chuikov.entity.quiz.Game;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PlayerDto {
    Long id;

    GameDto game;

    String name;

    Date timeStart;

    Date timeEnd;

    int score;

}
