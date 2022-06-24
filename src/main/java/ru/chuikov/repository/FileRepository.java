package ru.chuikov.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.chuikov.entity.File;

import java.util.List;

@Repository
public interface FileRepository extends CommonRepository<File> {
    @Query("SELECT f FROM File f left join f.creator c WHERE c.id = :id")
    List<File> findAllByUserId(@Param("id")Long userid);
}
