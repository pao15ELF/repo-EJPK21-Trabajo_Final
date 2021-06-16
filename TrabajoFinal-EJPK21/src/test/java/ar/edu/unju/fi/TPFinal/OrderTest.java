package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Order;
import ar.edu.unju.fi.TPFinal.model.OrderDetail;
import ar.edu.unju.fi.TPFinal.model.OrderDetailId;
import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IOrderDetailService;
import ar.edu.unju.fi.TPFinal.service.IOrderService;
import ar.edu.unju.fi.TPFinal.service.IProductService;
@SpringBootTest
class OrderTest {

	@Autowired
	private IOrderService orderService;
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	@Test
	void guardarOrderTest() {
		Product prod = productService.buscarProductPorId("SRN-LCH-01");
		Customer cust = customerService.buscarCustomerPorId(1); 
		LocalDate fecha = LocalDate.of(2021, 1, 4);
		LocalDate fecha2= LocalDate.of(2021, 1, 14);
		LocalDate fecha3 = LocalDate.of(2021, 2, 12);
		OrderDetailId detailId = new OrderDetailId();
		OrderDetail detail = new OrderDetail();
		Order order = new Order();
		
		//Cargar order
		order.setOrderDate(fecha);
		order.setRequiredDate(fecha2);
		order.setShippedDate(fecha3);
		order.setComments("entregado");
		order.setCustomerNumber(cust);
		order.setStatus("---");
		//Cargar id del  detalle de la orden
		detailId.setProductCode(prod);
		detailId.setOrderNumber(order);
		//cargar detalle de la orden
		detail.setOrderDetailId(detailId);
		detail.setPriceEach(160);
		detail.setQuantityOrdered(2);
		detail.setOrderLineNumber((short)4);
		
		orderService.guardarOrder(order);
		orderDetailService.guardarOrderDetail(detail);
		
		assertTrue(order.getComments()=="entregado");
	}

}
