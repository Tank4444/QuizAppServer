package ru.chuikov.entity.dto.quiz;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    Long id;

    String text;

    Boolean isRight;

    QuestionDto question;
}
