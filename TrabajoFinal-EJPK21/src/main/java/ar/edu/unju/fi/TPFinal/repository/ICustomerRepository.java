package ar.edu.unju.fi.TPFinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;

public interface ICustomerRepository extends CrudRepository<Customer,Integer> {

	public Employee findBySalesRepEmployeeNumber(Employee employee);
	
	public Customer findByCustomerNumber(Integer id);
}
