package ar.edu.unju.fi.TPFinal.service;

import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.model.ProductLine;

public interface IProductService {
	public void guardarProduct(Product producto);
	public Product buscarProductPorId(String id);
	public List<Product> buscarListaProductosPorLineProduct(ProductLine productLine);
}
