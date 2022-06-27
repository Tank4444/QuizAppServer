package ru.chuikov.repository.quiz;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chuikov.entity.quiz.Answer;
import ru.chuikov.entity.quiz.Game;
import ru.chuikov.repository.CommonRepository;

import java.util.List;

@Repository
public interface AnswerRepository extends CommonRepository<Answer> {
    //    @Query("SELECT g FROM Game g left join g.player c WHERE c.id = :id")
//    List<Game> findAllByPlayerId(@Param("id") Long playerId);
//@Query("SELECT g FROM Game g WHERE g.gameType = :type")
//List<Game> findAllByGameTypeId(@Param("type") GameType type);

        @Query("SELECT a FROM Answer a left join a.question q WHERE q.id = :id")
        List<Answer> findAllByQuestionId(@Param("id") Long questionId);

}
