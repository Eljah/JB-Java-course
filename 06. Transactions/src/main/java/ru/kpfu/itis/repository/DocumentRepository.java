package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Document;

/**
 * Created by eljah32 on 3/3/2018.
 */

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
