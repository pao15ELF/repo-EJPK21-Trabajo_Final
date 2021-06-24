package ar.edu.unju.fi.TPFinal.service;

import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Order;

public interface IOrderService {

	public void guardarOrder(Order order);
	
	public Order buscarOrderPorId(Integer id);
	
	public List<Order> buscarOrdersPorCustomer(Customer customer);
}
