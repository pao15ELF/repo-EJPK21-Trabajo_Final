package ar.edu.unju.fi.TPFinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.PaymentId;

public interface IPaymentRepository extends CrudRepository<Payment, PaymentId> {

}
