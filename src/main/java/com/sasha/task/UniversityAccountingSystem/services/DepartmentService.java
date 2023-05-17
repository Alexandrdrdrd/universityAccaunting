package com.sasha.task.UniversityAccountingSystem.services;

import com.sasha.task.UniversityAccountingSystem.entity.Degree;
import com.sasha.task.UniversityAccountingSystem.entity.Department;
import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import com.sasha.task.UniversityAccountingSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Retrieves the head of the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the department head information,
     * or "Department not found" if the department or the head is not found
     */
    public String getDepartmentHead(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department != null && department.getHead() != null) {
            String headName = department.getHead().getName();
            return "Head of " + departmentName + " department is " + headName;
        } else {
            return "Department not found";
        }
    }

    /**
     * Retrieves the statistics of the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the department statistics,
     * including the count of assistants, associate professors, and professors,
     * or "Department not found" if the department is not found
     */
    public String getDepartmentStatistics(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department != null) {
            long assistantCount = department.getLectors()
                    .stream()
                    .filter(lector -> lector.getDegree() == Degree.ASSISTANT)
                    .count();
            long associateProfessorCount = department.getLectors()
                    .stream()
                    .filter(lector -> lector.getDegree() == Degree.ASSOCIATE_PROFESSOR)
                    .count();
            long professorCount = department.getLectors()
                    .stream()
                    .filter(lector -> lector.getDegree() == Degree.PROFESSOR)
                    .count();
            return "assistants - " + assistantCount + ". associate professors - " +
                    associateProfessorCount + ". professors - " + professorCount;
        } else {
            return "Department not found";
        }
    }

    /**
     * Retrieves the average salary of the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the average salary of the department,
     * or "Department not found" if the department is not found
     */
    public String getAverageSalary(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department != null) {
            double averageSalary = department.getLectors()
                    .stream()
                    .mapToDouble(Lector::getSalary)
                    .average()
                    .orElse(0.0);
            return "The average salary of " + departmentName + " is " + averageSalary;
        } else {
            return "Department not found";
        }
    }


    /**
     * Retrieves the count of employees in the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the employee count in the department,
     * or "Department not found" if the department is not found
     */
    public String getEmployeeCount(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department != null) {
            int employeeCount = department.getLectors().size();
            return "Answer: " + employeeCount;
        } else {
            return "Department not found";
        }
    }
}