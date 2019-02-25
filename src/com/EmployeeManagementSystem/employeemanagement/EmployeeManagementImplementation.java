package com.murtaza.employeemanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.murtaza.employeemanagement.dataaccess.EmployeeDataAccess;
import com.murtaza.employeemanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements
		EmployeeManagementService {

	@Inject
	private EmployeeDataAccess dao;
	
	@Inject
	private ExternalPayrollSystem payrollSystem;
	
	@Resource
	private SessionContext ctx;
		
	@Override
	public void registerEmployee(Employee employee) throws ServiceUnavailableException {
		dao.insert(employee);
		
		payrollSystem.enrollEmployee(employee);
		
//		try {
//			payrollSystem.enrollEmployee(employee);
//		}
//		catch (ServiceUnavailableException e) {
//			ctx.setRollbackOnly();
//			throw e;
//		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		return dao.findBySurname(surname);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public double dummyInMemoryMethod() {
		return 109.29378;
	}

}
