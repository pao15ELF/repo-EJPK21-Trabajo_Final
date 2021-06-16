package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IOfficeService officeService;
	
	//@Test
	void testListaEmployees() {
		
		Office office = officeService.buscarOfficePorId("CTR");
		
		List<Employee> lista = employeeService.listaEmployeesPorOffice(office);
		assertEquals(lista.size(), 2);
		
	}

	@Test
	void testCargarEmployee() {
		
		Office office = officeService.buscarOfficePorId("CTR");
		
		Employee employee1 = new Employee();
		employee1.setEmail("jefe@gmail.com");
		employee1.setExtension("x1");
		employee1.setFirstName("principal");
		employee1.setJobTitle("Economista");
		employee1.setLastName("Lopez");
		employee1.setOfficeCode(office);
		employee1.setReportsTo(null);
		employeeService.guardarEmployee(employee1);
		
		
		Employee encontrado = employeeService.buscarEmployeePorId(1);
		Employee employee2 = new Employee();
		employee2.setEmail("ejemplo@gmail.com");
		employee2.setExtension("x900");
		employee2.setFirstName("ejemplo1");
		employee2.setJobTitle("contador");
		employee2.setLastName("ejemplo1");
		employee2.setOfficeCode(office);
		employee2.setReportsTo(encontrado);
		employeeService.guardarEmployee(employee2);
		
		Employee emp = employeeService.buscarEmployeePorId(2);
		
		
		assertEquals(employee2.getFirstName(),emp.getFirstName());
	}
	
	//@Test
	void testCustomers() {
		
		Employee encontrado = employeeService.buscarEmployeePorId(2);
		List<Customer> customers = encontrado.getCustomers();
		assertTrue(customers.size()==2);
	}
}
