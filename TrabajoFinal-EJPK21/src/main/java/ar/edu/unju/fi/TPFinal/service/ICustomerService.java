package ar.edu.unju.fi.TPFinal.service;

import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;

public interface ICustomerService {
	
	public void guardarCustomer(Customer customer);
	
	public Customer buscarCustomerPorId(Integer id);
	
	public List<Customer> buscarCustomersPorEmployee(Employee employee);
	
	public List<Customer> listaCustomers();
	
	public void eliminarCustomer(Integer customerNumber);
	
	public List<Customer> obtenerListaCustomersActivos(String status);
}
