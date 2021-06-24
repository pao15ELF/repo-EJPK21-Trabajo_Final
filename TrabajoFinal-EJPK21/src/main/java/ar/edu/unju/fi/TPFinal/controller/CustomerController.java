package ar.edu.unju.fi.TPFinal.controller;

import javax.validation.Valid;

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
	
	@Autowired
	@Qualifier("customerServiceImp")
	private ICustomerService customerService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private Customer customer;
	
	@GetMapping("/customer/nuevo")
	public ModelAndView getNuevoCustomerPage() {
		ModelAndView mav = new ModelAndView("nuevo_customer");
		mav.addObject("customer", customer);
		mav.addObject("employees", employeeService.listaemployees() );
		return mav;
	}
	
	@GetMapping("/customer/lista")
	public ModelAndView getListaCustomerPage() {
		ModelAndView mav = new ModelAndView("lista_customer");
		mav.addObject("customers", customerService.listaCustomers());
		return mav;
	}
	
	@GetMapping("/customer/eliminar/{customerNumber}")
	public ModelAndView getEliminarCustomerPage(@PathVariable(value = "customerNumber")Integer id) {
		ModelAndView mav = new ModelAndView("lista_customer");
		customerService.eliminarCustomer(id);
		mav.addObject("customers", customerService.listaCustomers());
		return mav;
	}
	
	@GetMapping("/customer/modificar/{customerNumber}")
	public ModelAndView getModificarCustomerPage(@PathVariable(value = "customerNumber")Integer id) {
		ModelAndView mav = new ModelAndView("nuevo_customer");
		Customer encontrado = customerService.buscarCustomerPorId(id);
		mav.addObject("customer", encontrado);
		mav.addObject("employees", employeeService.listaemployees() );
		return mav;
	}
	
	@PostMapping("/customer/guardar")
	public ModelAndView postGuardarCustomerPage(@Valid @ModelAttribute("customer") Customer unCustomer, BindingResult resultadoValidacion) {
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
