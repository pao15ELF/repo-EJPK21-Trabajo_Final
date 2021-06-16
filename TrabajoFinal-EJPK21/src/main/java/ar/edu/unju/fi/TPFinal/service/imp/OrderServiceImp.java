package ar.edu.unju.fi.TPFinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Order;
import ar.edu.unju.fi.TPFinal.repository.IOrderRepository;
import ar.edu.unju.fi.TPFinal.service.IOrderService;

@Service("orderServiceImp")
public class OrderServiceImp implements IOrderService{

	@Autowired
	private IOrderRepository orderRepository;
	
	@Override
	public void guardarOrder(Order order) {
		
		orderRepository.save(order);
	}

	@Override
	public Order buscarOrderPorId(Integer id) {
		Order order = orderRepository.findById(id).get();
		return order;
	}

}
