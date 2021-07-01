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
		
		office.setAddressLine1("Belgrano 766");
		office.setAddressLine2("Salta 112");
		office.setCity("Jujuy");
		office.setCountry("Argentina");
		office.setOfficeCode("Administración"); //id ingresado manualmente
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
		office1.setOfficeCode("Central"); //id ingresado manualmente
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
		office2.setOfficeCode("Sucursal01"); //id ingresado manualmente
		office2.setPhone("4232327");
		office2.setPostalCode("4600");
		office2.setState("---");
		office2.setTerritory("ARG");
		
		officeService.guardarOffice(office2);
		
		Office office3 = new Office();
		
		office3.setAddressLine1("19 de Abril 560");
		office3.setAddressLine2("---");
		office3.setCity("Jujuy");
		office3.setCountry("Argentina");
		office3.setOfficeCode("Sucursal02"); //id ingresado manualmente
		office3.setPhone("4678432");
		office3.setPostalCode("4600");
		office3.setState("---");
		office3.setTerritory("ARG");
		
		officeService.guardarOffice(office3);
		
		Office office4 = new Office();
		
		office4.setAddressLine1("Guemes 770");
		office4.setAddressLine2("---");
		office4.setCity("Jujuy");
		office4.setCountry("Argentina");
		office4.setOfficeCode("Sucursal03"); //id ingresado manualmente
		office4.setPhone("4232327");
		office4.setPostalCode("4600");
		office4.setState("---");
		office4.setTerritory("ARG");
		
		officeService.guardarOffice(office4);
		
		Office officeEnc = officeService.buscarOfficePorId("Sucursal01");
		
		assertNotNull(officeEnc);
	}
}
