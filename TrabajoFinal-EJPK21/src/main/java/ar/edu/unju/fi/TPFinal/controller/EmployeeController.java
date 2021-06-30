package ar.edu.unju.fi.TPFinal.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@Controller
public class EmployeeController {
	private static final Log LOGGER = LogFactory.getLog(EmployeeController.class);
	
	@Autowired
	private Employee employee;
	
	@Autowired
	@Qualifier("employeeServiceImp")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("officeServiceImp")
	private IOfficeService officeService;
	

	
	@GetMapping("/employee/nuevo")
	public ModelAndView getNuevoEmployeePage() {
		LOGGER.info("CONTROLLER: EmployeeController");
		LOGGER.info("METHOD: getNuevoEmployeePage()");
		LOGGER.info("RESULT: visualiza la pagina nuevo_employee.html, enviando la lista de oficinas,de empleados y un objeto del tipo empleado vacio");
		ModelAndView mav = new ModelAndView("nuevo_employee");
		mav.addObject("employee", employee);
		mav.addObject("offices", officeService.obtenerListaOffices());
		mav.addObject("employees", employeeService.listaemployees());
		return mav;
	}
	
	@GetMapping("/employee/lista")
	public ModelAndView getListaEmployeePage() {
		LOGGER.info("CONTROLLER: EmployeeController");
		LOGGER.info("METHOD: getListaEmployeePage()");
		LOGGER.info("RESULT: visualiza la pagina lista_employee.html con todos los datos de los empleados");
		ModelAndView mav = new ModelAndView("lista_employee");
		mav.addObject("employees", employeeService.listaemployees());
		return mav;
	}
	
	@GetMapping("/employee/eliminar/{employeeNumber}")
	public ModelAndView getEliminarEmployeePage(@PathVariable(value ="employeeNumber")Integer id) {
		LOGGER.info("CONTROLLER: EmployeeController");
		LOGGER.info("METHOD: getEliminarEmployeePage()");
		LOGGER.info("RESULT: elimina un empleado y visualiza la pagina lista_employee.html con todos los datos de los empleados");
		ModelAndView mav = new ModelAndView("lista_employee");
		//cambia a null los reportTo de cada empleado que reportaba al empleado a eliminar
		Employee encontrado = employeeService.buscarEmployeePorId(id);
		List<Employee> lista = employeeService.buscarEmployeePorReportTo(encontrado);
		for(Employee e: lista) {
			e.setReportsTo(null);
			employeeService.guardarEmployee(e);
		}
		employeeService.eliminarEmployee(id);
		mav.addObject("employees", employeeService.listaemployees());
		
		return mav;
	}
	
	@GetMapping("/employee/modificar/{employeeNumber}")
	public ModelAndView getModificarEmployeePage(@PathVariable(value = "employeeNumber")Integer id) {
		LOGGER.info("CONTROLLER: EmployeeController");
		LOGGER.info("METHOD: getModificarEmployeePage()");
		LOGGER.info("RESULT: modifica un empleado y visualiza la pagina lista_employee.html con todos los datos de los empleados");
		
		ModelAndView mav = new ModelAndView("nuevo_employee");
		Employee encontrado = employeeService.buscarEmployeePorId(id);
		mav.addObject("employee",encontrado );
		mav.addObject("offices", officeService.obtenerListaOffices());
		mav.addObject("employees", employeeService.listaemployees());
		return mav;
	}
	
	@PostMapping("/employee/guardar")
	public ModelAndView postGuardarEmployeePage(@Valid @ModelAttribute("employee")Employee unEmployee, BindingResult resultadoValidacion) {
		LOGGER.info("CONTROLLER: EmployeeController");
		LOGGER.info("METHOD: postGuardarEmployeePage()");
		LOGGER.info("RESULT: controla los datos del empleado cargado, si es correcto lo guarda y muestra nuevo_employee.html sino redirecciona a nuevo_employee.html ");
		
		ModelAndView mav;
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_employee");
			mav.addObject("employee", unEmployee);
			mav.addObject("offices", officeService.obtenerListaOffices());
			mav.addObject("employees",employeeService.listaemployees());
		}else {
			mav = new ModelAndView("lista_employee");
			employeeService.guardarEmployee(unEmployee);
			
			LOGGER.info("empleado a guardar:"+unEmployee.getOfficeCode());
			mav.addObject("employees", employeeService.listaemployees());
		}
		return mav;
	}
}
