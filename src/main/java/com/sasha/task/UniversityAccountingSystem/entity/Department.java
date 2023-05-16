package com.sasha.task.UniversityAccountingSystem.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "head_id")
    private Lector head;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "department_lector",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private Set<Lector> lectors;

    public Department() {
        lectors = new HashSet<>();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }

    public void addLector(Lector lector) {
        lectors.add(lector);
        lector.getDepartments().add(this);
    }

    public void removeLector(Lector lector) {
        lectors.remove(lector);
        lector.getDepartments().remove(this);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", head=" + (head != null ? head.getName() : null) +
                ", lectors=" + lectors.stream().map(Lector::getId).collect(Collectors.toList()) +
                '}';
    }
}