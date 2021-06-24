package ar.edu.unju.fi.TPFinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.PaymentId;
import ar.edu.unju.fi.TPFinal.repository.IPaymentRepository;
import ar.edu.unju.fi.TPFinal.service.IPaymentService;

@Service("paymentServiceImp")
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Override
	public void guardarPayment(Payment payment) {
		paymentRepository.save(payment);
		
	}

	@Override
	public Payment buscarPaymentPorId(PaymentId paymentId) {
		Payment payment = paymentRepository.findById(paymentId).get();
		return payment;
	}

	@Override
	public List<Payment> listaPayments() {
		List<Payment> lista = (List<Payment>) paymentRepository.findAll();
		return lista;
	}

	@Override
	public List<Payment> buscarPaymentsPorCustomer(Customer customer) {
		List<Payment> lista = paymentRepository.findByPaymentIdCustomersNumber(customer);
		return lista;
	}

}
