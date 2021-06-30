package ar.edu.unju.fi.TPFinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;

@Service("employeeServiceImp")
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public void guardarEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public Employee buscarEmployeePorId(Integer id) {
		Employee employee = employeeRepository.findByEmployeeNumber(id);
		return employee;
	}

	@Override
	public List<Employee> listaEmployeesPorOffice(Office office) {
		List<Employee> lista = employeeRepository.findAllByOfficeCode(office);
		return lista;
	}

	@Override
	public void eliminarEmployee(Integer employeeNumber) {
		employeeRepository.deleteById(employeeNumber);
		
	}

	@Override
	public List<Employee> listaemployees() {
		List<Employee> lista = (List<Employee>) employeeRepository.findAll();
		return lista;
	}

	@Override
	public List<Employee> buscarEmployeePorReportTo(Employee employee) {
		List<Employee> lista = employeeRepository.findByReportsTo(employee);
		return lista;
	}
}
