package ar.edu.unju.fi.TPFinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Payment;
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

}
