package ar.edu.unju.fi.TPFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Embeddable
@Component
public class PaymentId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerNumber")
	private Customer customersNumber;
	
	@NotEmpty(message="Debe ingresar el numero de check")
	@Column(name = "checkNumber", length=50, nullable=false)
	private String checkNumber; // tamaño 50

	/**
	 * 
	 */
	public PaymentId() {
	
	}

	/**
	 * @param customersNumber
	 * @param checkNumber
	 */
	public PaymentId(Customer customersNumber, String checkNumber) {
		
		this.customersNumber = customersNumber;
		this.checkNumber = checkNumber;
	}

	/**
	 * @return the customersNumber
	 */
	public Customer getCustomersNumber() {
		return customersNumber;
	}

	/**
	 * @param customersNumber the customersNumber to set
	 */
	public void setCustomersNumber(Customer customersNumber) {
		this.customersNumber = customersNumber;
	}

	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
