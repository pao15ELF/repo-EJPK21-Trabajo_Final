package ar.edu.unju.fi.TPFinal.service;

import ar.edu.unju.fi.TPFinal.model.Order;

public interface IOrderService {

	public void guardarOrder(Order order);
	
	public Order buscarOrderPorId(Integer id);
	
	
}
