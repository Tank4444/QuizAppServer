package ru.chuikov.repository.quiz;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.chuikov.entity.quiz.Question;
import ru.chuikov.entity.quiz.QuestionType;
import ru.chuikov.repository.CommonRepository;

import java.util.List;

@Repository
public interface QuestionRepository extends CommonRepository<Question> {
//    @Query("SELECT g FROM Game g left join g.player c WHERE c.id = :id")
//    List<Game> findAllByPlayerId(@Param("id") Long playerId);
//@Query("SELECT g FROM Game g WHERE g.gameType = :type")
//List<Game> findAllByGameTypeId(@Param("type") GameType type);

    @Query("select q from Question q where q.questionType = ?1")
    List<Question> findAllByQuestionType(QuestionType type);

    @Query("select q from Question q join q.game g where q.id = ?1")
    List<Question> findAllByGameId(Long gameId);

}
