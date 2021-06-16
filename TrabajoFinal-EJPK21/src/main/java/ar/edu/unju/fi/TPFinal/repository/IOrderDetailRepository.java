package ar.edu.unju.fi.TPFinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.OrderDetail;
import ar.edu.unju.fi.TPFinal.model.OrderDetailId;

public interface IOrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId>{

}
