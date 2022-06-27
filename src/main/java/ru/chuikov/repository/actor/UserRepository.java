package ru.chuikov.repository.actor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chuikov.entity.actor.User;
import ru.chuikov.repository.CommonRepository;

@Repository
public interface UserRepository extends CommonRepository<User> {

    @Query("FROM User where email = :name")
    User getByUsername(@Param("name")String username);

    @Query("FROM User where id = :id")
    User getByID(@Param("id")Long id);
}
