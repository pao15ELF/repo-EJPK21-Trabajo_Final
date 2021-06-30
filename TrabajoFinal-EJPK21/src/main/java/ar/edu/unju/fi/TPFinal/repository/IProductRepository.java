package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.model.ProductLine;

public interface IProductRepository extends CrudRepository<Product, String>{
	public List<Product> findByProductLine(ProductLine productLine);
	
	public List<Product> findByStatus(String status);
}
