package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.ProductLine;

public interface IProductLineRepository extends CrudRepository<ProductLine, String>{

	public List<ProductLine> findByStatus(String status);
}
