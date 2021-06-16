package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.model.ProductLine;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;
import ar.edu.unju.fi.TPFinal.service.IProductService;

@SpringBootTest
class ProductTest {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductLineService productLineService;
	
	@Test
	void testGuardarProducto() {
		
		
		ProductLine marca = productLineService.buscarProductLinePorId("SRN-01");
		
		Product producto1= new Product();
		
		producto1.setProductCode("SRN-YGT-01");
		producto1.setProductDescription("Yogurt sabor Frutilla La Serenisima de 1L");
		producto1.setProductName("Yogurt La Serenisima");
		producto1.setProductScale("1:10");
		producto1.setProductVendor("Lopez Roberto");
		producto1.setProductLine(marca);
		producto1.setQuantityInStock((short)1300);
		producto1.setMSRP(150);
		producto1.setBuyPrice(80);
		
		productService.guardarProduct(producto1);
		//Product productoEncontrado= productService.buscarProductPorId("SRN-YGT-01");
		
		
		Product producto2= new Product();
		
		producto2.setProductCode("SRN-LCH-01");
		producto2.setProductDescription("Leche Descremada La Serenisima de 1L en caja");
		producto2.setProductName("Leche La Serenisima");
		producto2.setProductScale("3:10");
		producto2.setProductVendor("Dominguez Mario");
		producto2.setProductLine(marca);
		producto2.setQuantityInStock((short)100);
		producto2.setMSRP(180);
		producto2.setBuyPrice(120);
		
		productService.guardarProduct(producto2);
		Product productoEncontrado= productService.buscarProductPorId("SRN-LCH-01");
		assertEquals(producto2.getBuyPrice(), productoEncontrado.getBuyPrice());
	}

}
