package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.model.Office;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

	public List<Employee> findAllByOfficeCode(Office office);
	
	public Employee findByEmployeeNumber(Integer id);
}
