package ar.edu.unju.fi.TPFinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.repository.ICustomerRepository;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;

@Service("customerServiceImp")
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public void guardarCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer buscarCustomerPorId(Integer id) {
		Customer customer = customerRepository.findByCustomerNumber(id);
		return customer;
	}

	@Override
	public Employee buscarEmployee(Employee employee) {
		Employee employeeEnc = customerRepository.findBySalesRepEmployeeNumber(employee);
		return employeeEnc;
	}

	
}
