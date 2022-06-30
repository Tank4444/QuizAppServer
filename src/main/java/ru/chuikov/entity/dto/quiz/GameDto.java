package ru.chuikov.entity.dto.quiz;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.actor.Player;
import ru.chuikov.entity.actor.User;
import ru.chuikov.entity.dto.actor.PlayerDto;
import ru.chuikov.entity.dto.actor.UserDto;
import ru.chuikov.entity.quiz.GameType;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class GameDto {
        Long id;

        @JsonIgnore
        UserDto creator;

        List<PlayerDto> player;

        GameType gameType;

        List<QuestionDto> questions;
}