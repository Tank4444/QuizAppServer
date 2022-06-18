package ru.chuikov.repository;

import org.springframework.stereotype.Repository;
import ru.chuikov.entity.Game;

@Repository
public interface GameRepository extends CommonRepository<Game> {
}
