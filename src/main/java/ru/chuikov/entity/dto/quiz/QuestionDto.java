package ru.chuikov.entity.dto.quiz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.chuikov.entity.quiz.Answer;
import ru.chuikov.entity.quiz.Game;
import ru.chuikov.entity.quiz.QuestionType;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

        Long id;

        String text;

        QuestionType questionType;

        List<AnswerDto> answers;

        Game game;

}