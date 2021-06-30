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

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;
import ar.edu.unju.fi.TPFinal.service.IProductService;

@Controller
public class ProductController {

	private static final Log LOGGER = LogFactory.getLog(ProductController.class);
	
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
		LOGGER.info("CONTROLLER: ProductController");
		LOGGER.info("METHOD: getNuevoProductPage()");
		LOGGER.info("RESULT: visualiza la pagina nuevo_employee.html, enviando la lista de productos en linea,una bandera y un objeto del tipo producto vacio");
		
		ModelAndView mav = new ModelAndView("nuevo_product");
		mav.addObject("product",product);
		mav.addObject("listaProductLine", productLineService.obtenerListaProductLinesEnLinea());
		mav.addObject("bandera", true);
		return mav;
		
	}
	
	@GetMapping("/product/lista")
	public ModelAndView getListaProductPage() {
		LOGGER.info("CONTROLLER: ProductController");
		LOGGER.info("METHOD: getListaProductPage()");
		LOGGER.info("RESULT: visualiza la pagina nuevo_employee.html, enviando la lista de productos en linea,una bandera y un objeto del tipo producto vacio");
		
		ModelAndView mav = new ModelAndView("lista_product");
		mav.addObject("products", productService.obtenerListaProducts());
		return mav;
	}
	
	@PostMapping("/product/guardar")
	public ModelAndView postGuardarProductPage(@Valid @ModelAttribute("product") Product unProduct, BindingResult resultadoValidacion ) {
		LOGGER.info("CONTROLLER: ProductController");
		LOGGER.info("METHOD:postGuardarProduct()");
		LOGGER.info("RESULT: controla los datos cargados, si estan correctos los guarda en db y muestra la pagina resultado_product.html sino redirecciona a nuevo_product.html");
		
		ModelAndView mav;
		//controlar que el id no este registrado en la base de datos
		Product pEncontrado = productService.buscarProductPorId(unProduct.getProductCode());
		String mensajeError = "";
		if (pEncontrado==null) {
			if (resultadoValidacion.hasErrors()) {
				mav = new ModelAndView("nuevo_product");
				mav.addObject("product", unProduct);
				mav.addObject("listaProductLine",productLineService.obtenerListaProductLinesEnLinea());
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
			mav.addObject("listaProductLine", productLineService.obtenerListaProductLinesEnLinea());
			mav.addObject("bandera", true);
		}
		return mav;
	}
	
	@PostMapping("/product/guardar/modificar")
	public ModelAndView postGuardarProductPage2(@Valid @ModelAttribute("product") Product unProduct, BindingResult resultadoValidacion ) {
		LOGGER.info("CONTROLLER: ProductController");
		LOGGER.info("METHOD: postGuardarProductPage2(), para guardar datos de un producto ya registrado en la db");
		LOGGER.info("RESULT: controla los datos cargados, si estan correctos los guarda en db"
				+ " y muestra la pagina resultado_product.html sino redirecciona a nuevo_product.html");
		
		ModelAndView mav;
			if (resultadoValidacion.hasErrors()) {
				mav = new ModelAndView("nuevo_product");
				mav.addObject("product", unProduct);
				mav.addObject("listaProductLine", productLineService.obtenerListaProductLinesEnLinea());
				mav.addObject("bandera", false);
			}else {
				productService.guardarProduct(unProduct);
				mav = new ModelAndView("resultado_product");
			}	
		return mav;
	}
	
	
	@GetMapping("/product/eliminar/{productCode}")
	public ModelAndView getEliminarProductPage(@PathVariable(value = "productCode") String id) {
		LOGGER.info("CONTROLLER: ProductController");
		LOGGER.info("METHOD:getEliminarProductPage()");
		LOGGER.info("RESULT: deja en FUERA DE LINEA a un producto"
				+ " y muestra la pagina lista_product.html");
		
		ModelAndView mav = new ModelAndView("lista_product");
		Product pEncontrado = productService.buscarProductPorId(id);
		pEncontrado.setStatus("FUERA DE LINEA");
		productService.guardarProduct(pEncontrado);
		mav.addObject("products", productService.obtenerListaProducts());
		return mav;
		
	}
	
	@GetMapping("/product/modificar/{productCode}")
	public ModelAndView getModificarProductPage(@PathVariable(value = "productCode") String id) {
		LOGGER.info("CONTROLLER: ProductController");
		LOGGER.info("METHOD:getModificarProductPage()");
		LOGGER.info("RESULT: busca el producto seleccionado en la db y redireccina a nuevo_product.html");
		ModelAndView mav = new ModelAndView("nuevo_product");
		Product pEncontrado = productService.buscarProductPorId(id);
		mav.addObject("product", pEncontrado);
		mav.addObject("listaProductLine", productLineService.obtenerListaProductLinesEnLinea());
		mav.addObject("bandera", false);
		return mav;
	}
	
}
