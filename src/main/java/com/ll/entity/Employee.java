package com.ll.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int email;
    private String department;
    private LocalDateTime hireDate;
    private double salary;
}
