package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.PaymentId;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IPaymentService;

@SpringBootTest
class PaymentTest {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IPaymentService paymentService;
	
	@Test
	void testGuardarPayment() {
		
		Customer customer1 = customerService.buscarCustomerPorId(1);
		LocalDate fecha = LocalDate.now();
		PaymentId payId1= new PaymentId();
		
		payId1.setCheckNumber("1001");
		payId1.setCustomersNumber(customer1);
		Payment payment1= new Payment();
		
		payment1.setPaymentId(payId1);
		payment1.setAmount(850);
		payment1.setPaymentDate(fecha);
		
		paymentService.guardarPayment(payment1);
		
		assertTrue(payment1.getAmount()==850);
	}

}
