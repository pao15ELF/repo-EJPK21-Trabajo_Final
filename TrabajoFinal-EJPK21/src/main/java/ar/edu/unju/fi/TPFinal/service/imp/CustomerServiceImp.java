package ar.edu.unju.fi.TPFinal.service.imp;

import java.util.List;

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
	public List<Customer> buscarCustomersPorEmployee(Employee employee) {

		List<Customer> lista = customerRepository.findBySalesRepEmployeeNumber(employee);
		return lista;
	}

	@Override
	public List<Customer> listaCustomers() {
		List<Customer> lista = (List<Customer>) customerRepository.findAll();
		return lista;
	}

	@Override
	public void eliminarCustomer(Integer customerNumber) {
		customerRepository.deleteById(customerNumber);
		
	}

	@Override
	public List<Customer> obtenerListaCustomersActivos(String status) {
		List<Customer> lista = customerRepository.findByStatus("Activo");
		return lista;
	}

	
}
