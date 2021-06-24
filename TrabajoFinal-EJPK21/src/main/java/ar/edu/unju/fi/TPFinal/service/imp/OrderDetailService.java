package ar.edu.unju.fi.TPFinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Order;
import ar.edu.unju.fi.TPFinal.model.OrderDetail;
import ar.edu.unju.fi.TPFinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.TPFinal.service.IOrderDetailService;

@Service("orderDetailServiceImp")
public class OrderDetailService implements IOrderDetailService{

	@Autowired
	private IOrderDetailRepository orderDetailRepository;
	
	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
		
	}

	@Override
	public List<OrderDetail> buscarOrdersPorOrderNumber(Order order) {
		List<OrderDetail> lista = orderDetailRepository.findByOrderDetailIdOrderNumber(order);
		return lista;
	}
	
}
