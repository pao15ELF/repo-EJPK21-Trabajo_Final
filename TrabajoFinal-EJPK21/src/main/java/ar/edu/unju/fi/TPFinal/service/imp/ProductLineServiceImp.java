package ar.edu.unju.fi.TPFinal.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.ProductLine;
import ar.edu.unju.fi.TPFinal.repository.IProductLineRepository;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;

@Service("productLineServiceImp")
public class ProductLineServiceImp implements IProductLineService{

	@Autowired
	private IProductLineRepository productLineRepository;
	
	@Override
	public void guardarProductLine(ProductLine productLine) {
		productLineRepository.save(productLine);
		
	}

	@Override
	public ProductLine buscarProductLinePorId(String id) {
		ProductLine marca=null;
		try {
			marca = productLineRepository.findById(id).get();
			
		}catch( Exception e) {
			e.getStackTrace();
			
		}
		
		return marca;
	}

	@Override
	public List<ProductLine> obtenerListaProductLines() {
		List<ProductLine> lista = (List<ProductLine>) productLineRepository.findAll();
		return lista;
	}

	@Override
	public void EliminarProductLine(ProductLine productLine) {
		productLineRepository.delete(productLine);
	}

	
}
