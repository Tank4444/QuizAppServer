package ru.chuikov.entity.dto.quiz;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.actor.Player;
import ru.chuikov.entity.actor.User;
import ru.chuikov.entity.dto.actor.PlayerDto;
import ru.chuikov.entity.quiz.GameType;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
        Long id;

        User creator;

        List<PlayerDto> player;

        GameType gameType;

        List<QuestionDto> questions;
}