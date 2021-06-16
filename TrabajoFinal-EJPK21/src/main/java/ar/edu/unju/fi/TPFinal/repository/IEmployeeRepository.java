package ar.edu.unju.fi.TPFinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}
