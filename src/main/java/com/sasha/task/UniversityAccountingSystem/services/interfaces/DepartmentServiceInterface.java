package com.sasha.task.UniversityAccountingSystem.services.interfaces;


public interface DepartmentServiceInterface {

    /**
     * Retrieves the head of the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the department head information,
     * or "Department not found" if the department or the head is not found
     */
    String getDepartmentHead(String departmentName);

    /**
     * Retrieves the statistics of the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the department statistics,
     * including the count of assistants, associate professors, and professors,
     * or "Department not found" if the department is not found
     */
    String getDepartmentStatistics(String departmentName);

    /**
     * Retrieves the average salary of the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the average salary of the department,
     * or "Department not found" if the department is not found
     */
    String getAverageSalary(String departmentName);

    /**
     * Retrieves the count of employees in the department with the specified name.
     *
     * @param departmentName the name of the department
     * @return a string representation of the employee count in the department,
     * or "Department not found" if the department is not found
     */
    String getEmployeeCount(String departmentName);
}
