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
		
		Office office = officeService.buscarOfficePorId("Central");
		Office office1 = officeService.buscarOfficePorId("Sucursal02");
		
		Employee employee1 = new Employee();
		employee1.setEmail("jefe@gmail.com");
		employee1.setExtension("x1");
		employee1.setFirstName("Nicole");
		employee1.setJobTitle("Jefe");
		employee1.setLastName("Lopez");
		employee1.setOfficeCode(office);
		employee1.setReportsTo(null);
		employeeService.guardarEmployee(employee1);
		
		
		Employee encontrado = employeeService.buscarEmployeePorId(1);
		
		Employee employee2 = new Employee();
		employee2.setEmail("empleado1@gmail.com");
		employee2.setExtension("x900");
		employee2.setFirstName("Ramiro");
		employee2.setJobTitle("Cajero");
		employee2.setLastName("Plaza");
		employee2.setOfficeCode(office1);
		employee2.setReportsTo(encontrado);
		employeeService.guardarEmployee(employee2);
		
		Employee employee3 = new Employee();
		employee3.setEmail("empleado2@gmail.com");
		employee3.setExtension("x901");
		employee3.setFirstName("Dylan");
		employee3.setJobTitle("Cajero");
		employee3.setLastName("Llampa");
		employee3.setOfficeCode(office1);
		employee3.setReportsTo(encontrado);
		employeeService.guardarEmployee(employee3);
		
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
