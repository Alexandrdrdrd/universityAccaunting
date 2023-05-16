package com.sasha.task.UniversityAccountingSystem.repository;

import com.sasha.task.UniversityAccountingSystem.entity.Department;
import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    List<Department> findAll();


}
