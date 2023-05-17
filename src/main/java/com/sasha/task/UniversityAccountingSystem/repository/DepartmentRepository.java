package com.sasha.task.UniversityAccountingSystem.repository;

import com.sasha.task.UniversityAccountingSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Retrieves a department from the database by its name.
     *
     * @param name the name of the department
     * @return the department with the specified name, or null if not found
     */
    Department findByName(String name);
}