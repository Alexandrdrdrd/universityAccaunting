package com.sasha.task.UniversityAccountingSystem.entity;

import com.sasha.task.UniversityAccountingSystem.abstract_entity.Worker;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a lector in the university.
 */
@Entity
@Table(name = "lectors")
public class Lector extends Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "degree")
    private Degree degree;

    @Column(name = "salary")
    private double salary;

    @ManyToMany(mappedBy = "lectors", fetch = FetchType.EAGER)
    private Set<Department> departments;

    /**
     * Default constructor.
     * Initializes the set of departments.
     */
    public Lector() {
        departments = new HashSet<>();
    }

    /**
     * Constructs a lector with the specified name, degree, and salary.
     *
     * @param name   the name of the lector
     * @param degree the degree of the lector
     * @param salary the salary of the lector
     */
    public Lector(String name, Degree degree, double salary) {
        this.departments = new HashSet<>();
        this.name = name;
        this.degree = degree;
        this.salary = salary;
    }

    /**
     * Returns the ID of the lector.
     *
     * @return the ID of the lector
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the lector.
     *
     * @param id the ID of the lector
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the lector.
     *
     * @return the name of the lector
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the lector.
     *
     * @param name the name of the lector
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the degree of the lector.
     *
     * @return the degree of the lector
     */
    public Degree getDegree() {
        return degree;
    }

    /**
     * Sets the degree of the lector.
     *
     * @param degree the degree of the lector
     */
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    /**
     * Returns the salary of the lector.
     *
     * @return the salary of the lector
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the lector.
     *
     * @param salary the salary of the lector
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the set of departments the lector is associated with.
     *
     * @return the set of departments the lector is associated with
     */
    public Set<Department> getDepartments() {
        return departments;
    }

    /**
     * Sets the set of departments the lector is associated with.
     *
     * @param departments the set of departments the lector is associated with
     */
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    /**
     * Returns a string representation of the lector.
     *
     * @return a string representation of the lector
     */
    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree.getDisplayName() +
                ", salary=" + salary +
                '}';
    }
}
