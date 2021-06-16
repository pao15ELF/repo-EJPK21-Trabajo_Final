package ar.edu.unju.fi.TPFinal.service;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;

public interface ICustomerService {
	
	public void guardarCustomer(Customer customer);
	
	public Customer buscarCustomerPorId(Integer id);
	
	public Employee buscarEmployee(Employee employee);
}
