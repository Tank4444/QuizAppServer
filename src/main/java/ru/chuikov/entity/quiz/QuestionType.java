package ru.chuikov.entity.quiz;


import javax.persistence.*;
import java.util.List;


public enum QuestionType {
    MANY_ANSWERS,
    OPEN,
    TRUE_FALSE
    ;

    QuestionType(){

    }
}
