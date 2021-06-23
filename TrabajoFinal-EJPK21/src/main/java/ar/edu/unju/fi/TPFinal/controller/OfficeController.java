package ar.edu.unju.fi.TPFinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

//@Controller
public class OfficeController {

	@Autowired
	@Qualifier("officeServiceImp")
	private IOfficeService officeService;
	
	@Autowired
	private Office office;
	
	@GetMapping("/office/nuevo")
	public ModelAndView getNuevoOfficePage() {
		ModelAndView mav = new ModelAndView("nuevo_office");
		mav.addObject("office",office);
		return mav;
	}
	
	@GetMapping("/office/lista")
	public ModelAndView getListaOfficePage() {
		ModelAndView mav = new ModelAndView("lista_office");
		mav.addObject("offices", officeService.obtenerListaOffices());
		return mav;
	}
	
	@GetMapping("/office/eliminar/{officeCode}")
	public ModelAndView getEliminarOfficePage(@PathVariable(value = "officeCode") String id) {
		ModelAndView mav = new ModelAndView("lista_office");
		officeService.eliminarOffice(id);
		mav.addObject("offices", officeService.obtenerListaOffices());
		
		return mav;
	}
	
	@GetMapping("/office/modificar/{officeCode}")
	public ModelAndView getModificarOfficePage(@PathVariable(value = "officeCode")String id) {
		ModelAndView mav = new ModelAndView("nuevo_office");
		Office encontrado = officeService.buscarOfficePorId(id);
		mav.addObject("office", encontrado);
		return mav;
	}
	
	@PostMapping("/office/guardar")
	public ModelAndView postGuardarOfficePage(@Valid @ModelAttribute("office") Office unOffice, BindingResult resultadoValidacion) {
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
}