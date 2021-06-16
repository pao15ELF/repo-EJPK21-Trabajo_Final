package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;
@SpringBootTest
class CustomerTest {

	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	void testCrearCustomer() {
		
		Employee emp = employeeService.buscarEmployeePorId(2);
		
		Customer customer1 = new Customer();
		customer1.setAddressLine1("mza14 l8");
		customer1.setAddressLine2("---");
		customer1.setCity("BS AS");
		customer1.setContactFirstName("Cliente1");
		customer1.setContactLastName("apellidocliente");
		customer1.setCountry("Argetina");
		customer1.setCreditLimit(3000d);
		customer1.setCustomerName("Cliente--");
	
		customer1.setPhone("7896543");
		customer1.setPostalCode("2345");
		customer1.setSalesRepEmployeeNumber(emp);
		customer1.setState("active");
		customerService.guardarCustomer(customer1);
		
		Customer customer2 = new Customer();
		customer2.setAddressLine1("mza14 l8");
		customer2.setAddressLine2("---");
		customer2.setCity("SAN JUAN");
		customer2.setContactFirstName("Cliente2");
		customer2.setContactLastName("apellidocliente2");
		customer2.setCountry("Argentina");
		customer2.setCreditLimit(3000d);
		customer2.setCustomerName("Cliente2--");
		
		customer2.setPhone("4234990");
		customer2.setPostalCode("4100");
		customer2.setSalesRepEmployeeNumber(emp);
		customer2.setState("inactive");
		customerService.guardarCustomer(customer2);
		
		Customer encontrado = customerService.buscarCustomerPorId(1);
		assertNotNull(encontrado);
		
	}

}
