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
import ar.edu.unju.fi.TPFinal.model.Product;
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
	
	private List<Product> productosOrdenados = new ArrayList<Product>();
	
	private double total=0;
	
	private Product controlProd;
	
	@GetMapping("/orderDetail/nuevo")
	public ModelAndView nuevoOrderDetailPage() {
		LOGGER.info("CONTROLLER: OderController");
		LOGGER.info("METHOD: nuevoOrderDetailPage()");
		LOGGER.info("RESULT: muestra la pagina nuevoorderDetail.html enviando un objeto de tipodeOrden y una lista"
				+ "con todos los productos EN LINEA ");
		
		ModelAndView mav = new ModelAndView("nuevo_orderDetail"); 
		mav.addObject("orderDetail", orderDetail);
		mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
		return mav;
	}
	
	public void modificarStock(short cant) {
		short stock=controlProd.getQuantityInStock();
		stock=(short)(stock-cant);
		controlProd.setQuantityInStock(cant);
	}
	
	@PostMapping("/orderDetail/cargar/siguiente")
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("orderDetail")OrderDetail unOrderDetail, BindingResult resultadoValidacion) {
		LOGGER.info("CONTROLLER: OderController");
		LOGGER.info("METHOD: guardarOrderPage()");
		LOGGER.info("RESULT: controla que los datos esten cargados correctamente para cargar la pagina nuevo_OrderDetail.html con"
				+ "un objeto vacio, de lo contrario redirecciona a la misma pagina pero con los datos");
		
		ModelAndView mav = new ModelAndView("nuevo_orderDetail");
		//orderDetails.add(unOrderDetail);
		short stockProd=0,cantidadOrdenada=0;
		String mensajeControl="";
		if (resultadoValidacion.hasErrors()) {
			mav.addObject("orderDetail", unOrderDetail);
			mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
			
		}else {
			   orderDetails.add(unOrderDetail);
				//control de stock
				controlProd = productService.buscarProductPorId(unOrderDetail.getOrderDetailId().getProductCode().getProductCode());
				cantidadOrdenada=(short)unOrderDetail.getQuantityOrdered();			
				stockProd= controlProd.getQuantityInStock();
				if (stockProd<=0) {
					mensajeControl="No hay stock para el producto solicitado";
					mav.addObject("mensajeControl", mensajeControl);
					mav.addObject("orderDetail", unOrderDetail);
					mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
				}else {
					if(cantidadOrdenada>stockProd) {
						mensajeControl="La cantidad ordenada supera al stock del producto solicitado";
						mav.addObject("mensajeControl", mensajeControl);
						mav.addObject("orderDetail", unOrderDetail);
						mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
					}else {
						modificarStock(cantidadOrdenada);
						productosOrdenados.add(controlProd);
						mav.addObject("orderDetail", orderDetail);
						mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
						controlProd = new Product();
					}
				}
		}
		return mav;
	}
	
	@PostMapping("/order/nuevo")
	public ModelAndView postNuevoOrderPage(@Valid @ModelAttribute("orderDetail") OrderDetail unOrderDetail,BindingResult resultadoValidacion) {
		LOGGER.info("CONTROLLER: OderController");
		LOGGER.info("METHOD: postNuevoOrderPage()");
		LOGGER.info("RESULT: controla que el ultimo dato cargado este bien cargado sino "
				+ "redirecciona a nuevo_orderDetail.html, sino controla la nueva orden, si tiene errores"
				+ "redirecciona nuevamente a nuevo_order.html");
		
		ModelAndView mav;
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_orderDetail");
			mav.addObject("orderDetail", unOrderDetail);
			mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
			
		}else {
			orderDetails.add(unOrderDetail);
			short stockProd=0,cantidadOrdenada=0;
			String mensajeControl="";
			controlProd = productService.buscarProductPorId(unOrderDetail.getOrderDetailId().getProductCode().getProductCode());
			cantidadOrdenada = (short) unOrderDetail.getQuantityOrdered();
			stockProd=controlProd.getQuantityInStock();
			
				if (stockProd<=0) {
					mav = new ModelAndView("nuevo_orderDetail");
					mensajeControl="No hay stock para el producto solicitado";
					mav.addObject("orderDetail", unOrderDetail);
					mav.addObject("products",productService.obtenerListaProductsPorEstadoActivo());
					mav.addObject("mensajeControl", mensajeControl);
				}else {
					if(cantidadOrdenada>stockProd) {
						mav = new ModelAndView("nuevo_orderDetail");
						mensajeControl="La cantidad ordenada supera al stock del producto solicitado";
						mav.addObject("orderDetail", unOrderDetail);
						mav.addObject("products",productService.obtenerListaProductsPorEstadoActivo());
						mav.addObject("mensajeControl", mensajeControl);
					}else {
						modificarStock(cantidadOrdenada);
						productosOrdenados.add(controlProd); 
						mav = new ModelAndView("nuevo_order");
						mav.addObject("order", order);
						mav.addObject("customers", customerService.listaCustomers());
						controlProd = new Product();
					}
				}
		}
		return mav;
	}
	
	@PostMapping("/order/control")
	public ModelAndView pagarOrderPage(@Valid @ModelAttribute("order")Order unOrder, BindingResult resultadoValidacion) {
		LOGGER.info("CONTROLLER: OderController");
		LOGGER.info("METHOD: pagarOrderPage()");
		LOGGER.info("RESULT: calcula el monto total de la compra de todos los productos y redirecciona a nuevo_payment.html");
		
		ModelAndView mav;
		int stock=0,cantidadOrdenada=0;
		//calculo auxiliar de monto total de la compra
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_order");
			mav.addObject("order", unOrder);
			mav.addObject("customers", customerService.listaCustomers());
		}else {
			orderService.guardarOrder(unOrder);
			//controlar stock
			for(OrderDetail o: orderDetails) {
				OrderDetailId oId = new OrderDetailId();
				oId.setProductCode(o.getOrderDetailId().getProductCode());	
				Product productoE = productService.buscarProductPorId(o.getOrderDetailId().getProductCode().getProductCode());
				cantidadOrdenada = (short) o.getQuantityOrdered();
				stock = productoE.getQuantityInStock()-cantidadOrdenada;
				productoE.setQuantityInStock((short)stock);
				productService.guardarProduct(productoE);
				oId.setOrderNumber(unOrder);
				o.setOrderDetailId(oId);
				orderDetailService.guardarOrderDetail(o);
				total=total+(o.getPriceEach()*o.getQuantityOrdered());
				oId=null;
				productoE=null;
			}
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
		LOGGER.info("CONTROLLER: OderController");
		LOGGER.info("METHOD: realizarPaymentPage()");
		LOGGER.info("RESULT: controla que los datos de pago esten bien, si es asi realiza el pago y muestra la pagina resultado_payment.html"
				+ "sino redirecciona a nuevo_payment.html ");
		
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
