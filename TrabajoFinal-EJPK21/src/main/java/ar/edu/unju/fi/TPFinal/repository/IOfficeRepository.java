package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Office;

public interface IOfficeRepository extends CrudRepository<Office, String> {

	public List<Office> findByOfficeCodeContaining(String officeCode);
}
