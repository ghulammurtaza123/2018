package com.murtaza.employeemanagement;

import java.util.List;

import javax.ejb.Remote;

import com.murtaza.employeemanagement.domain.Employee;
import javax.naming.ServiceUnavailableException;

@Remote
public interface EmployeeManagementService {

	public void registerEmployee(Employee employee) throws ServiceUnavailableException;
	public List<Employee> getAllEmployees();
	public List<Employee> searchBySurname(String surname);
}
