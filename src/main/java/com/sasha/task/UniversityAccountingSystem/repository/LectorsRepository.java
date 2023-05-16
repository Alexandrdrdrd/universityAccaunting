package com.sasha.task.UniversityAccountingSystem.repository;

import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorsRepository extends JpaRepository<Lector, Long> {
    @Override
    List<Lector> findAll();
}
