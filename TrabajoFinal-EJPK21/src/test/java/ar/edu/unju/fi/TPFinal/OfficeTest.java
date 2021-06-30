package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@SpringBootTest
class OfficeTest {

	@Autowired
	private IOfficeService officeService;
	
	@Test
	void cargarOfficeTest() {
		
		Office office = new Office();
		
		office.setAddressLine1("belgrano 766");
		office.setAddressLine2("salta 452");
		office.setCity("Jujuy");
		office.setCountry("Argentina");
		office.setOfficeCode("CTR"); //id ingresado manualmente
		office.setPhone("155197089");
		office.setPostalCode("4600");
		office.setState("---");
		office.setTerritory("ARG");
		office.setStatus("ACTIVO");
		
		officeService.guardarOffice(office);
		
		
		Office office1 = new Office();
		
		office1.setAddressLine1("La Madrid 256");
		office1.setAddressLine2("Piso 6");
		office1.setCity("Jujuy");
		office1.setCountry("Argentina");
		office1.setOfficeCode("ADM"); //id ingresado manualmente
		office1.setPhone("156856900");
		office1.setPostalCode("4600");
		office1.setState("---");
		office1.setTerritory("ARG");
		
		officeService.guardarOffice(office1);
		
		
		Office office2 = new Office();
		
		office2.setAddressLine1("Lavalle 800");
		office2.setAddressLine2("---");
		office2.setCity("Jujuy");
		office2.setCountry("Argentina");
		office2.setOfficeCode("LOC"); //id ingresado manualmente
		office2.setPhone("155802020");
		office2.setPostalCode("4600");
		office2.setState("---");
		office2.setTerritory("ARG");
		
		officeService.guardarOffice(office2);
		
		Office officeEnc = officeService.buscarOfficePorId("CTR");
		
		assertNotNull(officeEnc);
	}
}
