package com.sasha.task.UniversityAccountingSystem.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Entity representing a department in the university.
 */
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "head_id")
    private Lector head;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "department_lector",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private Set<Lector> lectors;

    /**
     * Default constructor.
     * Initializes the set of lectors.
     */
    public Department() {
        lectors = new HashSet<>();
    }

    /**
     * Constructs a department with the specified name and head lector.
     *
     * @param name the name of the department
     * @param head the head lector of the department
     */
    public Department(String name, Lector head) {
        this.name = name;
        this.head = head;
    }

    /**
     * Returns the ID of the department.
     *
     * @return the ID of the department
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the department.
     *
     * @param id the ID of the department
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the department.
     *
     * @return the name of the department
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the department.
     *
     * @param name the name of the department
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the head lector of the department.
     *
     * @return the head lector of the department
     */
    public Lector getHead() {
        return head;
    }

    /**
     * Sets the head lector of the department.
     *
     * @param head the head lector of the department
     */
    public void setHead(Lector head) {
        this.head = head;
    }

    /**
     * Returns the set of lectors in the department.
     *
     * @return the set of lectors in the department
     */
    public Set<Lector> getLectors() {
        return lectors;
    }

    /**
     * Sets the set of lectors in the department.
     *
     * @param lectors the set of lectors in the department
     */
    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }

    /**
     * Adds a lector to the department.
     * Also adds the department to the lector's set of departments.
     *
     * @param lector the lector to add
     */
    public void addLector(Lector lector) {
        if (lectors == null) {
            lectors = new HashSet<>();
        }
        lectors.add(lector);
        lector.getDepartments().add(this);
    }

    /**
     * Removes a lector from the department.
     * Also removes the department from the lector's set of departments.
     *
     * @param lector the lector to remove
     */
    public void removeLector(Lector lector) {
        lectors.remove(lector);
        lector.getDepartments().remove(this);
    }

    /**
     * Returns a string representation of the department.
     *
     * @return a string representation of the department
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head=" + (head != null ? head.getName() : null) +
                ", lectors=" + lectors.stream().map(Lector::getName).collect(Collectors.toList()) +
                '}';
    }
}
