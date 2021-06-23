package ar.edu.unju.fi.TPFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.ProductLine;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;

@Controller
public class ProductLineController {
		
	@Autowired
	@Qualifier("productLineServiceImp")
	private IProductLineService productLineService;
	
	@Autowired
	private ProductLine productLine;
	
	@GetMapping("/productLine/nuevo")
	public ModelAndView getProductLinePage() {
		ModelAndView mav = new ModelAndView("nuevo_productLine");
		mav.addObject("productLine", productLine );
		mav.addObject("bandera", true);
		return mav;
	}
	
	//validar datos agregar despues @valid y BindingResult
	@PostMapping("/productLine/guardar")
	public ModelAndView postGuardarProductLinepage(@ModelAttribute("productLine") ProductLine unProductLine) {
		ModelAndView mav;
		//buscar si el id del product line ya se encuentra registrado
		ProductLine encontrado= productLineService.buscarProductLinePorId(unProductLine.getProductLine());
		String mensajeError = "";
		if (encontrado!=null) {
			mensajeError = "La marca o linea de producto ya se encuentra cargada en la Base de Datos";
			mav = new ModelAndView("nuevo_productLine");
			mav.addObject("mensajeError", mensajeError);
			mav.addObject("productLine", unProductLine);
			mav.addObject("bandera", true);
		}
		else {
				productLineService.guardarProductLine(unProductLine);
				mav = new ModelAndView("resultado_productLine");		
		}
		return mav;
	}
	
	@PostMapping("/productLine/guardar/modificar")
	public ModelAndView postGuardarProductLinepage2(@ModelAttribute("productLine") ProductLine unProductLine) {
		ModelAndView mav = new ModelAndView("resultado_productLine");		
		productLineService.guardarProductLine(unProductLine);				
		return mav;
	}
	
	
	@GetMapping("/productLine/lista")
	public ModelAndView getMostrarProductLinesPage() {
		ModelAndView mav = new ModelAndView("lista_productLine");
		mav.addObject("productLines", productLineService.obtenerListaProductLines());
		return mav;
	}
	
	@GetMapping("/productLine/eliminar/{productLine}")
	public ModelAndView getEliminarProductLinePage(@PathVariable(value="productLine") String id) {
		ProductLine encontrado = productLineService.buscarProductLinePorId(id);
		productLineService.EliminarProductLine(encontrado);
		ModelAndView mav = new ModelAndView("lista_productLine");
		mav.addObject("productLines", productLineService.obtenerListaProductLines());
		return mav;
		
	}
	
	@GetMapping("/productLine/modificar/{productLine}")
	public ModelAndView getModificarProductLinePage(@PathVariable(value="productLine") String id) {
		ProductLine encontrado = productLineService.buscarProductLinePorId(id);
		ModelAndView mav = new ModelAndView("nuevo_productLine");
		mav.addObject("productLine", encontrado);
		mav.addObject("bandera", false);
		return mav;
		
	}
	
	
}
