package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Integer>{

	public List<Order> findByCustomerNumber(Customer customer);
}
