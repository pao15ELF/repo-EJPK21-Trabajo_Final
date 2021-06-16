package ar.edu.unju.fi.TPFinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.OrderDetail;
import ar.edu.unju.fi.TPFinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.TPFinal.service.IOrderDetailService;

@Service("orderDetailService")
public class OrderDetailService implements IOrderDetailService{

	@Autowired
	private IOrderDetailRepository orderDetailRepository;
	
	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
		
	}

}
