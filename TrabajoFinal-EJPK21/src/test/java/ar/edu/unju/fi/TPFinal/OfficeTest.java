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
		
		officeService.guardarOffice(office);
		
		Office officeEnc = officeService.buscarOfficePorId("CTR");
		
		assertNotNull(officeEnc);
	}
}
