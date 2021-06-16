package ar.edu.unju.fi.TPFinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Integer>{

}
