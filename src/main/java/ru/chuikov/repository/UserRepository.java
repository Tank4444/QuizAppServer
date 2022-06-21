package ru.chuikov.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chuikov.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {

    @Query("FROM User where email = :name")
    Optional<User> findByUsername(@Param("name")String username);
}
