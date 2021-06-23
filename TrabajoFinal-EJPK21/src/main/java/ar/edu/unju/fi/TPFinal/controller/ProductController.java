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

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;
import ar.edu.unju.fi.TPFinal.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	@Qualifier("productServiceImp")
	private IProductService productService;
	
	@Autowired
	@Qualifier("productLineServiceImp")
	private IProductLineService productLineService;
	
	@Autowired
	private Product product;
	
	@GetMapping("/product/nuevo")
	public ModelAndView getNuevoProductPage(){
		ModelAndView mav = new ModelAndView("nuevo_product");
		mav.addObject("product",product);
		mav.addObject("listaProductLine", productLineService.obtenerListaProductLines());
		mav.addObject("bandera", true);
		return mav;
		
	}
	
	@GetMapping("/product/lista")
	public ModelAndView getListaProductPage() {
		ModelAndView mav = new ModelAndView("lista_product");
		mav.addObject("products", productService.obtenerListaProducts());
		return mav;
	}
	
	@PostMapping("/product/guardar")
	public ModelAndView postGuardarProductPage(@Valid @ModelAttribute("product") Product unProduct, BindingResult resultadoValidacion ) {
		ModelAndView mav;
		//controlar que el id no este registrado en la base de datos
		Product pEncontrado = productService.buscarProductPorId(unProduct.getProductCode());
		String mensajeError = "";
		if (pEncontrado==null) {
			if (resultadoValidacion.hasErrors()) {
				mav = new ModelAndView("nuevo_product");
				mav.addObject("product", unProduct);
				mav.addObject("listaProductLine", productLineService.obtenerListaProductLines());
				mav.addObject("bandera", true);
			}else {
				productService.guardarProduct(unProduct);
				mav = new ModelAndView("resultado_product");
			}	
		}
		else {
			mav = new ModelAndView("nuevo_product");
			mensajeError = "El codigo del producto ya se encuentra registrado en la base de datos";
			mav.addObject("mensajeError", mensajeError);
			mav.addObject("product", unProduct);
			mav.addObject("listaProductLine", productLineService.obtenerListaProductLines());
			mav.addObject("bandera", true);
		}
		return mav;
	}
	
	@PostMapping("/product/guardar/modificar")
	public ModelAndView postGuardarProductPage2(@Valid @ModelAttribute("product") Product unProduct, BindingResult resultadoValidacion ) {
		ModelAndView mav;
			if (resultadoValidacion.hasErrors()) {
				mav = new ModelAndView("nuevo_product");
				mav.addObject("product", unProduct);
				mav.addObject("listaProductLine", productLineService.obtenerListaProductLines());
				mav.addObject("bandera", false);
			}else {
				productService.guardarProduct(unProduct);
				mav = new ModelAndView("resultado_product");
			}	
		return mav;
	}
	
	@GetMapping("/product/eliminar/{productCode}")
	public ModelAndView getEliminarProductPage(@PathVariable(value = "productCode") String id) {
		ModelAndView mav = new ModelAndView("lista_product");
		Product pEncontrado = productService.buscarProductPorId(id);
		productService.eliminarProduct(pEncontrado);
		return mav;
		
	}
	
	@GetMapping("/product/modificar/{productCode}")
	public ModelAndView getModificarProductPage(@PathVariable(value = "productCode") String id) {
		ModelAndView mav = new ModelAndView("nuevo_product");
		Product pEncontrado = productService.buscarProductPorId(id);
		mav.addObject("product", pEncontrado);
		mav.addObject("listaProductLine", productLineService.obtenerListaProductLines());
		mav.addObject("bandera", false);
		return mav;
	}
	
}
