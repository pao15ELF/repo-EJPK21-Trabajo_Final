package ar.edu.unju.fi.TPFinal.service;

import java.util.List;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.PaymentId;

public interface IPaymentService {

	public void guardarPayment(Payment payment);
	
	public Payment buscarPaymentPorId(PaymentId paymentId);
	
	public List<Payment> listaPayments();
	
	public List<Payment> buscarPaymentsPorCustomer(Customer customer);
}
