package ar.edu.unju.fi.TPFinal.service.imp;


import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.TPFinal.model.ProductLine;
import ar.edu.unju.fi.TPFinal.repository.IProductLineRepository;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;

@Service("productLineServiceImp")
public class ProductLineServiceImp implements IProductLineService{
private static final Log LOGGER = LogFactory.getLog(ProductLineServiceImp.class);
	
	@Autowired
	private IProductLineRepository productLineRepository;
	
	@Override
	public void guardarProductLine(ProductLine productLine, MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			LOGGER.info("Archivo incorrecto");
		}
		try {
			productLine.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
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

	@Override
	public List<ProductLine> obtenerListaProductLinesEnLinea() {
		List<ProductLine> lista = productLineRepository.findByStatus("EN LINEA");
		return lista;
	}

	@Override
	public void guardarProductLine(ProductLine product) {
		productLineRepository.save(product);
	}

	
	
}
