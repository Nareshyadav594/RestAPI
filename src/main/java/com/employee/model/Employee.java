package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String department;
}
