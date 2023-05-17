package com.sasha.task.UniversityAccountingSystem.repository;

import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    /**
     * Retrieves a list of lectors from the database whose names contain the specified template.
     *
     * @param template the template used to search for lectors by name
     * @return a list of lectors whose names contain the specified template
     */
    List<Lector> findByNameContaining(String template);
}