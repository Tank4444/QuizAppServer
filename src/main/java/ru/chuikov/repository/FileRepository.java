package ru.chuikov.repository;

import org.springframework.stereotype.Repository;
import ru.chuikov.entity.File;

@Repository
public interface FileRepository extends CommonRepository<File> {
}
