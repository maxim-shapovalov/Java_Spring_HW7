package ru.gb.spring.my_timesheet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String department;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
//    @JoinTable(
//            name = "employee_project",
//            joinColumns = @JoinColumn(name ="employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "project_id")
//    )
    private List<Project> projects;
}
