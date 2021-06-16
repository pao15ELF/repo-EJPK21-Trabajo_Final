package ar.edu.unju.fi.TPFinal.service;


import ar.edu.unju.fi.TPFinal.model.ProductLine;

public interface IProductLineService {

	public void guardarProductLine(ProductLine productLine);
	
	public ProductLine buscarProductLinePorId(String id);
	
	
}
