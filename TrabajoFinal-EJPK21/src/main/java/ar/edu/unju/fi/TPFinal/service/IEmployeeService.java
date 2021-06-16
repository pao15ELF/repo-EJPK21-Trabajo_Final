package ar.edu.unju.fi.TPFinal.service;

import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.model.Office;

public interface IEmployeeService {
	
	public void guardarEmployee(Employee employee);
	
	public Employee buscarEmployeePorId(Integer id);
	
	public List<Employee> listaEmployeesPorOffice(Office office);
}
