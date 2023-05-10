package com.suntech.stapi.service;

import java.util.List;

import com.suntech.stapi.entity.Employee;

public interface StreamApiService {
	
	public Employee saveEmployees(Employee employee);
	
	//public void saveEmployees(List<Employee> employee);
	
	public List<Employee> getEmployees();
	
	public List<Employee> getEmp(Employee employee);
	
	public List<String> getMappedEmployee(Employee employee);

	public List<Employee> getSortedEmployee(Employee employee);


}
