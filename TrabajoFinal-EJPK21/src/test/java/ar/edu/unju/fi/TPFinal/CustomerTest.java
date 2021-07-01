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
		customer1.setAddressLine1("MZA 14 L8");
		customer1.setAddressLine2("---");
		customer1.setCity("San Salvador de Jujuy");
		customer1.setContactFirstName("Eduardo");
		customer1.setContactLastName("Tolaba");
		customer1.setCountry("Argetina");
		customer1.setCreditLimit(3000d);
		customer1.setCustomerName("Eduardo Tolaba");
	
		customer1.setPhone("155789045");
		customer1.setPostalCode("4600");
		customer1.setSalesRepEmployeeNumber(emp);
		customer1.setState("---");
		customer1.setStatus("Activo");
		customerService.guardarCustomer(customer1);
		
		Customer customer2 = new Customer();
		customer2.setAddressLine1("Las vicuñas 123");
		customer2.setAddressLine2("---");
		customer2.setCity("Perico");
		customer2.setContactFirstName("Gabriela");
		customer2.setContactLastName("Llampa");
		customer2.setCountry("Argentina");
		customer2.setCreditLimit(3000d);
		customer2.setCustomerName("Gabriela Llampa");
		
		customer2.setPhone("4234990");
		customer2.setPostalCode("4600");
		customer2.setSalesRepEmployeeNumber(emp);
		customer2.setState("inactive");
		customer2.setStatus("Activo");
		customerService.guardarCustomer(customer2);
		
		Customer encontrado = customerService.buscarCustomerPorId(1);
		assertNotNull(encontrado);
		
	}

}
