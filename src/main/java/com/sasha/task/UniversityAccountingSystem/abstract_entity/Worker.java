package com.sasha.task.UniversityAccountingSystem.abstract_entity;

/**
 * An abstract class representing a worker.
 */
public abstract class Worker {
    private Long id;
    private String name;
    private double salary;

    /**
     * Returns the ID of the worker.
     *
     * @return the ID of the worker
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the worker.
     *
     * @param id the ID of the worker
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the worker.
     *
     * @return the name of the worker
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the worker.
     *
     * @param name the name of the worker
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the salary of the worker.
     *
     * @return the salary of the worker
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the worker.
     *
     * @param salary the salary of the worker
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a string representation of the worker.
     *
     * @return a string representation of the worker
     */
    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
