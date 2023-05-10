package com.suntech.stapi.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.stapi.entity.Employee;
import com.suntech.stapi.repository.StreamApiRepository;

@Service
public class StreamApiServiceImpl implements StreamApiService {

	@Autowired
	private StreamApiRepository streamApiRepository;

	/*
	 * <------------------STREAM-API METHODS USED HERE--------------------->
	 * 
	 * stream()-> It returns a stream consisting of the elements of this stream that
	 * match the given predicate.
	 * 
	 * sorted()-> It returns a stream consisting of the elements of this stream,
	 * sorted according to natural order. If the elements of this stream are not
	 * Comparable, a java.lang.ClassCastException may be thrown when the terminal
	 * operation is executed.
	 * 
	 * peek()-> It returns a stream consisting of the elements of this stream,
	 * additionally performing the provided action on each element as elements are
	 * consumed from the resulting stream.
	 * 
	 * collect()-> It allows us to perform mutable fold operations (repackaging
	 * elements to some data structures and applying some additional logic,
	 * concatenating them, etc.) on data elements held in a Stream instance.
	 * 
	 * filter()-> Java stream provides a method filter() to filter stream elements
	 * on the basis of given predicate. Suppose you want to get only even elements
	 * of your list then you can do this easily with the help of filter method. This
	 * method takes predicate as an argument and returns a stream of consisting of
	 * resulted elements.
	 * 
	 */

	public Employee saveEmployees(Employee employee) {

		return streamApiRepository.save(employee);

	}

	public List<Employee> getEmployees() {

		return streamApiRepository.findAll();

	}

	public List<Employee> getEmp(Employee employee) {
		List<Employee> list = streamApiRepository.findAll();
		if (list != null) {
			List<Employee> storingNewData = list.stream().filter(emp -> emp.getSalary() >= 500000)
					.collect(Collectors.toList());
			return storingNewData;
		} else {
			return null;
		}

	}

	public List<String> getMappedEmployee(Employee employee) {
		List<Employee> newList = streamApiRepository.findAll();
		if (newList != null) {
			List<String> storeMappedData = newList.stream().map(empl -> empl.getName()).collect(Collectors.toList());
			// List<String> storeMappedData=
			// newList.stream().map(Employee::getName()).collect(Collectors.toList());
			return storeMappedData;
		} else {
			return null;
		}
	}

	public List<Employee> getSortedEmployee(Employee employee) {
		List<Employee> listed = streamApiRepository.findAll();
		if (listed != null) {
			List<Employee> storeSortedData = listed.stream()
					.sorted(Comparator.comparingInt(Employee::getEmpId).reversed())
					.peek(emp -> emp.setName(emp.getName().toUpperCase())).collect(Collectors.toList());
			// System.out.println(storeSortedData);
			return storeSortedData;
		} else {
			return null;
		}
	}

}
