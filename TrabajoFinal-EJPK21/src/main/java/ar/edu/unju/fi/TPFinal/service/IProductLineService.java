package ar.edu.unju.fi.TPFinal.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.TPFinal.model.ProductLine;

public interface IProductLineService {

public void guardarProductLine(ProductLine productLine,MultipartFile file);
	
	public void guardarProductLine(ProductLine product);
	
	public ProductLine buscarProductLinePorId(String id);
	
	public List<ProductLine> obtenerListaProductLines();
	
	public void EliminarProductLine(ProductLine productLine);
	
	public List<ProductLine> obtenerListaProductLinesEnLinea();
}
