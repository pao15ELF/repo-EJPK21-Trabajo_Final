package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;

public interface ICustomerRepository extends CrudRepository<Customer,Integer> {

public Customer findByCustomerNumber(Integer id);
	
	public List<Customer> findBySalesRepEmployeeNumber(Employee employee);
}
