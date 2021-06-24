package ar.edu.unju.fi.TPFinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Entity
@Table(name = "PAYMENTS")
@Component
public class Payment {
	
	@EmbeddedId
	@Autowired
	private PaymentId paymentId;
	
	@NotNull(message="Debe ingresar fecha de pago")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "paymentDate", nullable=false)
	private LocalDate paymentDate; 
	
	@Min(value=0, message="El valor minimo del monto debe ser mayor a cero")
	@Column(name = "amount", nullable =false)
	private double amount;
	
	
	public Payment()
	{
		
	}


	/**
	 * @param paymentId
	 * @param paymentDate
	 * @param amount
	 */
	public Payment(PaymentId paymentId, LocalDate paymentDate, double amount) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	/**
	 * @return the paymentId
	 */
	public PaymentId getPaymentId() {
		return paymentId;
	}


	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(PaymentId paymentId) {
		this.paymentId = paymentId;
	}


	/**
	 * @return the paymentDate
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}


	
}
