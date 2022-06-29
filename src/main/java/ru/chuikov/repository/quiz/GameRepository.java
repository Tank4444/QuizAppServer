package ru.chuikov.repository.quiz;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chuikov.entity.quiz.Game;
import ru.chuikov.entity.quiz.GameType;
import ru.chuikov.repository.CommonRepository;

import java.util.List;

@Repository
public interface GameRepository extends CommonRepository<Game> {

    @Query("SELECT g FROM Game g left join g.creator c WHERE c.id = :id")
    List<Game> findAllByCreatorId(@Param("id") Long creatorId);
    @Query("SELECT g FROM Game g left join g.player c WHERE c.id = :id")
    List<Game> findAllByPlayerId(@Param("id") Long playerId);

    @Query("SELECT g FROM Game g left join g.player c WHERE c.id = g.id")
    List<Game> findAllPlayers();

    @Query("SELECT g FROM Game g WHERE g.gameType = :type")
    List<Game> findAllByGameTypeId(@Param("type")GameType type);


}
