package ar.edu.unju.fi.TPFinal.service;

import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Order;
import ar.edu.unju.fi.TPFinal.model.OrderDetail;

public interface IOrderDetailService {

	public void guardarOrderDetail(OrderDetail orderDetail);
	
	public List<OrderDetail> buscarOrdersPorOrderNumber(Order order);
}
