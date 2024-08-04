package com.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long emp_id;
	 private String emp_name;
	 private double emp_salary;
	 private String emp_designation;
	 private int emp_experience;
	 private String emp_city;
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}
	public String getEmp_designation() {
		return emp_designation;
	}
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	public int getEmp_experience() {
		return emp_experience;
	}
	public void setEmp_experience(int emp_experience) {
		this.emp_experience = emp_experience;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary
				+ ", emp_designation=" + emp_designation + ", emp_experience=" + emp_experience + ", emp_city="
				+ emp_city + "]";
	}
	
	public Employee() {
		
	}
	public Employee(long emp_id, String emp_name, double emp_salary, String emp_designation, int emp_experience,
			String emp_city) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_designation = emp_designation;
		this.emp_experience = emp_experience;
		this.emp_city = emp_city;
	}
	
}
