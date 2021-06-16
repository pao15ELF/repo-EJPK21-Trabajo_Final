package ar.edu.unju.fi.TPFinal.service;


import ar.edu.unju.fi.TPFinal.model.Office;

public interface IOfficeService {
	
	public void guardarOffice(Office office);
	
	public Office buscarOfficePorId(String id);
	
	
}
