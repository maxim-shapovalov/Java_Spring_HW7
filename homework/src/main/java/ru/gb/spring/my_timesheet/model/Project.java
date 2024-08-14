package ru.gb.spring.my_timesheet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
//    @ManyToMany
//    @JoinTable(
//            name = "employee_project",
//            joinColumns = @JoinColumn(name ="project_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id")
//    )
//    private List<Employee> employees;

    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private List<Employee> employees;
}
