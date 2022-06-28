package ru.chuikov.entity.dto.actor;


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
public class PlayerDto {
    Long id;

    GameDto game;

    String name;

    Date timeStart;

    Date timeEnd;

    int score;

}
