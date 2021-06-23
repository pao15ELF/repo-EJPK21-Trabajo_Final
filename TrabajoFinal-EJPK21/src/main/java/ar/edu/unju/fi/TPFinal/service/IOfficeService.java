package ar.edu.unju.fi.TPFinal.service;


import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Office;

public interface IOfficeService {
	
	public void guardarOffice(Office office);
	
	public Office buscarOfficePorId(String id);
	
	public List<Office> obtenerListaOffices();
	
	public void eliminarOffice(String officeId);
}
