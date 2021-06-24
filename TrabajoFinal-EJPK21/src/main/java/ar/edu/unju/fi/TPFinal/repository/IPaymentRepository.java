package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.PaymentId;

public interface IPaymentRepository extends CrudRepository<Payment, PaymentId> {

	public List<Payment> findByPaymentIdCustomersNumber(Customer customer);
}
