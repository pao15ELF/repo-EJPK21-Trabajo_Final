package ar.edu.unju.fi.TPFinal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Order;
import ar.edu.unju.fi.TPFinal.model.OrderDetail;
import ar.edu.unju.fi.TPFinal.model.OrderDetailId;
import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.PaymentId;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IOrderDetailService;
import ar.edu.unju.fi.TPFinal.service.IOrderService;
import ar.edu.unju.fi.TPFinal.service.IPaymentService;
import ar.edu.unju.fi.TPFinal.service.IProductService;

@Controller
public class OrderController {
	private static final Log LOGGER = LogFactory.getLog(OrderController.class);
	@Autowired
	private Order order;
	
	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private Payment payment;
	
	@Autowired
	@Qualifier("orderServiceImp")
	private IOrderService orderService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	@Qualifier("orderDetailServiceImp")
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IPaymentService paymentService;
	
	private Customer customer1;
	
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	private double total=0;
	
	@GetMapping("/orderDetail/nuevo")
	public ModelAndView nuevoOrderDetailPage() {
		ModelAndView mav = new ModelAndView("nuevo_orderDetail"); 
		mav.addObject("orderDetail", orderDetail);
		mav.addObject("products", productService.obtenerListaProducts());
		return mav;
	}
	
	@PostMapping("/orderDetail/cargar/siguiente")
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("orderDetail")OrderDetail unOrderDetail, BindingResult resultadoValidacion) {
		ModelAndView mav = new ModelAndView("nuevo_orderDetail");
		if (resultadoValidacion.hasErrors()) {
			mav.addObject("orderDetail", unOrderDetail);
			mav.addObject("products", productService.obtenerListaProducts());
			
		}else {
			orderDetails.add(unOrderDetail);
			LOGGER.info("cantidad ordeerdatil"+unOrderDetail.getOrderDetailId().getProductCode());
			mav.addObject("orderDetail", orderDetail);
			mav.addObject("products", productService.obtenerListaProducts());	
		}
		return mav;
	}
	
	@GetMapping("/order/nuevo")
	public ModelAndView nuevoOrderPage() {
		ModelAndView mav = new ModelAndView("nuevo_order");
		mav.addObject("order", order);
		mav.addObject("customers", customerService.listaCustomers());
		return mav;
	}
	
	@PostMapping("/order/control")
	public ModelAndView pagarOrderPage(@Valid @ModelAttribute("order")Order unOrder, BindingResult resultadoValidacion) {
		ModelAndView mav;
		//calculo auxiliar de monto total de la compra
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_order");
			mav.addObject("order", unOrder);
			mav.addObject("customers", customerService.listaCustomers());
		}else {
			orderService.guardarOrder(unOrder);
			for(OrderDetail o: orderDetails) {
				OrderDetailId oId = new OrderDetailId();
				oId.setProductCode(o.getOrderDetailId().getProductCode());
				oId.setOrderNumber(unOrder);
				o.setOrderDetailId(oId);
				orderDetailService.guardarOrderDetail(o);
				total=total+(o.getPriceEach()*o.getQuantityOrdered());
				oId=null;
			}
			LOGGER.info("cliente1 "+unOrder.getCustomerNumber().getCustomerNumber());
			customer1 = customerService.buscarCustomerPorId(unOrder.getCustomerNumber().getCustomerNumber());
			mav = new ModelAndView("nuevo_payment");			
			mav.addObject("payment", payment);
			mav.addObject("customer", customer1);
			
			mav.addObject("total", total);
		}
		return mav;
		
	}
	
	@PostMapping("/payment/guardar")
	public ModelAndView realizarPaymentPage(@Valid @ModelAttribute("payment")Payment unPayment, BindingResult resultadoValidacion) {
		ModelAndView mav;
		PaymentId pId = new PaymentId();
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_payment");
			mav.addObject("customer",customer1);
			mav.addObject("payment", unPayment);
			mav.addObject("total", total);
		}
		else {
			pId.setCheckNumber(unPayment.getPaymentId().getCheckNumber());
			pId.setCustomersNumber(customer1);
			unPayment.setPaymentId(pId);
			unPayment.setAmount(total);
			paymentService.guardarPayment(unPayment);
			mav = new ModelAndView("resultado_payment");
			mav.addObject("payment", unPayment);
			customer1= new Customer();
			total=0;
			orderDetails= new ArrayList<OrderDetail>();;
		}
		return mav;
		
	}
}
