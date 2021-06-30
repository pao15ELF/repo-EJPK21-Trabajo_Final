package ar.edu.unju.fi.TPFinal.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;

@Controller
public class CustomerController {
	private static final Log LOGGER = LogFactory.getLog(CustomerController.class);
	
	@Autowired
	@Qualifier("customerServiceImp")
	private ICustomerService customerService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private Customer customer;
	
	@GetMapping("/customer/nuevo")
	public ModelAndView getNuevoCustomerPage() {
		LOGGER.info("CONTROLLER: CustomerController");
		LOGGER.info("METHOD: getNuevoCustomerPage()");
		LOGGER.info("RESULT: visualiza la pagina nuevo_customer.html");
		ModelAndView mav = new ModelAndView("nuevo_customer");
		mav.addObject("customer", customer);
		mav.addObject("employees", employeeService.listaemployees() );
		return mav;
	}
	
	@GetMapping("/customer/lista")
	public ModelAndView getListaCustomerPage() {
		LOGGER.info("CONTROLLER: CustomerController");
		LOGGER.info("METHOD: getListaCustomerPage()");
		LOGGER.info("RESULT: visualiza la pagina lista_customer.html con los datos de todos los customers");
		ModelAndView mav = new ModelAndView("lista_customer");
		mav.addObject("customers", customerService.listaCustomers());
		return mav;
	}
	
	@GetMapping("/customer/eliminar/{customerNumber}")
	public ModelAndView getEliminarCustomerPage(@PathVariable(value = "customerNumber")Integer id) {
		LOGGER.info("CONTROLLER: CustomerController");
		LOGGER.info("METHOD: getEliminarCustomerPage()");
		LOGGER.info("RESULT: elimina un cliente y visualiza la pagina lista_customer.html");
		ModelAndView mav = new ModelAndView("lista_customer");
		Customer encontrado = customerService.buscarCustomerPorId(id);
		encontrado.setStatus("Inactivo");
		customerService.guardarCustomer(encontrado);
		mav.addObject("customers", customerService.listaCustomers());
		return mav;
	}
	
	@GetMapping("/customer/modificar/{customerNumber}")
	public ModelAndView getModificarCustomerPage(@PathVariable(value = "customerNumber")Integer id) {
		LOGGER.info("CONTROLLER: CustomerController");
		LOGGER.info("METHOD: getModificarCustomerPage()");
		LOGGER.info("RESULT: modifica un cliente visualizando la pagina nuevo_customer.html");
		ModelAndView mav = new ModelAndView("nuevo_customer");
		Customer encontrado = customerService.buscarCustomerPorId(id);
		mav.addObject("customer", encontrado);
		mav.addObject("employees", employeeService.listaemployees() );
		return mav;
	}
	
	@PostMapping("/customer/guardar")
	public ModelAndView postGuardarCustomerPage(@Valid @ModelAttribute("customer") Customer unCustomer, BindingResult resultadoValidacion) {
		LOGGER.info("CONTROLLER: CustomerController");
		LOGGER.info("METHOD: postGuardarCustomerPage()");
		LOGGER.info("RESULT: controla, si los datos cargados son correctos muestra la pagina lista_customer, sino redirige a nuevo_customer.html");
		
		ModelAndView mav;
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_customer");
			mav.addObject("customer", unCustomer);
			mav.addObject("employees", employeeService.listaemployees() );
		}
		else {
			mav = new ModelAndView("lista_customer");
			customerService.guardarCustomer(unCustomer);
			mav.addObject("customers", customerService.listaCustomers());
			
		}
		return mav;
	}
}
