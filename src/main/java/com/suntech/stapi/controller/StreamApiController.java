package com.suntech.stapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suntech.stapi.entity.Employee;
import com.suntech.stapi.service.StreamApiServiceImpl;

@RestController
public class StreamApiController {
	
	@Autowired
	private StreamApiServiceImpl streamApiServiceImpl;
	
	
	  @PostMapping("/saveInfo") 
	  public Employee saveEmployees(@RequestBody Employee
	  employee) { 
		  return streamApiServiceImpl.saveEmployees(employee); 
		  }
	 
	
	/*
	 * @PostMapping("/saveInfo") public void saveEmployees(@RequestBody
	 * List<Employee> employee) { streamApiServiceImpl.saveEmployees(employee); }
	 */
	@GetMapping("/getInfo")
	public List<Employee> getEmployees()
	{
		return streamApiServiceImpl.getEmployees().stream().filter(employee ->
		 employee.getSalary()>=500000).collect(Collectors.toList());
	}
	
	@GetMapping("/getIt")
	public List<Employee> getEmp(Employee employee)
	{
		return streamApiServiceImpl.getEmp(employee);
	}
	
	@GetMapping("/mapIt")
	public List<String> getMappedEmployee(Employee employee)
	{
		return streamApiServiceImpl.getMappedEmployee(employee);
	}
	
	@GetMapping("/sortIt")
	public List<Employee> getSortedEmployee(Employee employee)
	{
		return streamApiServiceImpl.getSortedEmployee(employee);
	}

}
