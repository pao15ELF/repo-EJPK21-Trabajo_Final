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

import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@Controller
public class OfficeController {

	private static final Log LOGGER = LogFactory.getLog(OfficeController.class);
	
	@Autowired
	@Qualifier("officeServiceImp")
	private IOfficeService officeService;
	
	@Autowired
	private Office office;
	
	//metodo no aplicado
	@GetMapping("/office/nuevo")
	public ModelAndView getNuevoOfficePage() {
		LOGGER.info("CONTROLLER: OfficeController");
		LOGGER.info("METHOD: getNuevoOfficePage()");
		LOGGER.info("RESULT: visualiza la pagina nuevo_office.html, enviando un objeto del tipo oficina vacio");
		
		ModelAndView mav = new ModelAndView("nuevo_office");
		mav.addObject("office",office);
		return mav;
	}
	
	@GetMapping("/office/lista")
	public ModelAndView getListaOfficePage() {
		LOGGER.info("CONTROLLER: OfficeController");
		LOGGER.info("METHOD: getListaOfficePage()");
		LOGGER.info("RESULT: visualiza la pagina lista_office.html con todos los datos de las oficinas");
		
		ModelAndView mav = new ModelAndView("lista_office");
		mav.addObject("officeAux", office);
		mav.addObject("offices", officeService.obtenerListaOffices());
		return mav;
	}
	
	//metodo no aplicado
	@GetMapping("/office/eliminar/{officeCode}")
	public ModelAndView getEliminarOfficePage(@PathVariable(value = "officeCode") String id) {
		LOGGER.info("CONTROLLER: OfficeController");
		LOGGER.info("METHOD: getEliminarOfficePage()");
		LOGGER.info("RESULT: elimina una oficina y visualiza la pagina lista_office.html");
		
		ModelAndView mav = new ModelAndView("lista_office");
		officeService.eliminarOffice(id);
		mav.addObject("offices", officeService.obtenerListaOffices());
		
		return mav;
	}
	
	//metodo no aplicado
	@GetMapping("/office/modificar/{officeCode}")
	public ModelAndView getModificarOfficePage(@PathVariable(value = "officeCode")String id) {
		LOGGER.info("CONTROLLER: OfficeController");
		LOGGER.info("METHOD: getModificarOfficePage()");
		LOGGER.info("RESULT: modifica una oficina visualizando la pagina nuevo_office.html");
		
		ModelAndView mav = new ModelAndView("nuevo_office");
		Office encontrado = officeService.buscarOfficePorId(id);
		mav.addObject("office", encontrado);
		return mav;
	}
	
	//metodo no aplicado 
	@PostMapping("/office/guardar")
	public ModelAndView postGuardarOfficePage(@Valid @ModelAttribute("office") Office unOffice, BindingResult resultadoValidacion) {
		LOGGER.info("CONTROLLER: OfficeController");
		LOGGER.info("METHOD: postGuardarOfficePage()");
		LOGGER.info("RESULT: controla los datos cargados de una oficina,  si son correctos los guarda y redirecciona a lista_office.html, sino visualiza la pagina nuevo_office.html");
		
		ModelAndView mav;
		//se busca el id en la base de datos antes de guardar el objeto office
		Office encontrado = officeService.buscarOfficePorId(unOffice.getOfficeCode());
		String mensajeError = "";
		if (encontrado==null) {
			if (resultadoValidacion.hasErrors()) {
				mav = new ModelAndView("nuevo_office");
				mav.addObject("office", unOffice);
			}else {
				mav = new ModelAndView("lista_office");
				mav.addObject("offices", officeService.obtenerListaOffices());
			}
		}else {
			mensajeError = "El codigo del edificio ya se encuentra cargado en la base de datos. Ingrese otro";
			mav = new ModelAndView("nuevo_office");
			mav.addObject("office", encontrado);
			mav.addObject("mensajeError", mensajeError);
		}
		return mav;
	}
	
	@PostMapping("/office/buscar")
	public ModelAndView postBuscarOffice(@ModelAttribute("officeAux")Office buscado) {
		LOGGER.info("CONTROLLER: OfficeController");
		LOGGER.info("METHOD: postBuscarOffice()");
		LOGGER.info("RESULT: busca los edificios que coiciden con la busqueda y muestra los resultados en la pagina lista_office.html");
		
		ModelAndView mav = new ModelAndView("lista_office");
		String mensaje="";
			List<Office> listaEncontrado = officeService.buscarOfficePorOfficeCode(buscado.getOfficeCode());
			if(listaEncontrado==null) {
				mensaje="NINGUNA OFICINA COINCIDE CON LA BUSQUEDA";
				mav.addObject("mensaje", mensaje);
			}	
			mav.addObject("officeAux", office);
			mav.addObject("offices", listaEncontrado);
		return mav;
	}
}