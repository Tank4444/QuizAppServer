package ru.chuikov.repository.actor;

import org.springframework.stereotype.Repository;
import ru.chuikov.entity.actor.Player;
import ru.chuikov.repository.CommonRepository;

@Repository
public interface PlayerRepository extends CommonRepository<Player> {
}
