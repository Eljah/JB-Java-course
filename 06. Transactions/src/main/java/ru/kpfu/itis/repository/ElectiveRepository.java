package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Elective;
import ru.kpfu.itis.model.Student;

import java.util.List;

/**
 * Created by eljah32 on 3/3/2018.
 */

@Repository
public interface ElectiveRepository extends JpaRepository<Elective, Long> {

    Elective findByName(String name);
}
