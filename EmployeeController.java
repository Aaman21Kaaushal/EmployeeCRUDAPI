package com.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employee")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return"Employee created in database";
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList :: add);	
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		
	}
	
	@GetMapping("/employee/{emp_id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long emp_id){
		Optional<Employee> emp = employeeRepository.findById(emp_id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/employee/{emp_id}")
	public String updateEmployeeById(@PathVariable long emp_id,@RequestBody Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(emp_id);
		if(emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_salary(employee.getEmp_salary());
			existEmp.setEmp_designation(employee.getEmp_designation());
			existEmp.setEmp_experience(employee.getEmp_experience());
			existEmp.setEmp_city(employee.getEmp_city());
			employeeRepository.save(existEmp);
			return "Employee Detail against Id "+emp_id+"updated";
		}else {
			return "Employee Detail doesn't exist for emp_id"+emp_id;
			
		}
	}
	
	@DeleteMapping("/employee/{emp_id}")
	public String deleteEmployeeById(@PathVariable long emp_id) {
		employeeRepository.deleteById(emp_id);
		return"Employee  Deleted Successfully";
	}
	}
	

