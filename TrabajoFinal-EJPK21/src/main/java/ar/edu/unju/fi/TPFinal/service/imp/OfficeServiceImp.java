package ar.edu.unju.fi.TPFinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.repository.IOfficeRepository;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@Service("officeServiceImp")
public class OfficeServiceImp implements IOfficeService{

	@Autowired
	private IOfficeRepository officeRepository;
	
	@Override
	public void guardarOffice(Office office) {
		officeRepository.save(office);
		
	}

	@Override
	public Office buscarOfficePorId(String id) {
		Office office = officeRepository.findById(id).get();
		return office;
	}

	@Override
	public List<Office> obtenerListaOffices() {
		List<Office> lista = (List<Office>) officeRepository.findAll();
		return lista;
	}

	@Override
	public void eliminarOffice(String officeId) {
		officeRepository.deleteById(officeId);
		
	}
}
