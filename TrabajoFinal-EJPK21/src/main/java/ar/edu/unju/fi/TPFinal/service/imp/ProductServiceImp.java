package ar.edu.unju.fi.TPFinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.model.ProductLine;
import ar.edu.unju.fi.TPFinal.repository.IProductRepository;
import ar.edu.unju.fi.TPFinal.service.IProductService;

@Service("productServiceImp")
public class ProductServiceImp implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public void guardarProduct(Product producto) {
		productRepository.save(producto);
		
	}

	@Override
	public Product buscarProductPorId(String id) {
		Product producto=null;
		try {
			producto = productRepository.findById(id).get();
		}catch(Exception e) {
			e.getCause();
		}
		
		return producto;
	}

	@Override
	public List<Product> buscarListaProductosPorLineProduct(ProductLine productLine) {
		List<Product> lista = productRepository.findByProductLine(productLine);
		return lista;
	}
	
	@Override
	public void eliminarProduct(Product product) {
		productRepository.delete(product);
		
	}

	@Override
	public List<Product> obtenerListaProducts() {
		List<Product> lista = (List<Product>) productRepository.findAll();
		return lista;
	}

	@Override
	public List<Product> obtenerListaProductsPorEstadoActivo() {
		List<Product> lista = productRepository.findByStatus("EN LINEA");
		return lista;
	}

}
