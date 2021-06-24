package ar.edu.unju.fi.TPFinal.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Embeddable
@Component
public class OrderDetailId implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "orderNumber")
	private Order orderNumber;
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productCode")
	private Product productCode; //tamaño 15
	
	public OrderDetailId()
	{
		
	}

	/**
	 * @param orderNumber
	 * @param productCode
	 */
	public OrderDetailId(Order orderNumber, Product productCode) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}

	/**
	 * @return the orderNumber
	 */
	public Order getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the productCode
	 */
	public Product getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDetailId [orderNumber=" + orderNumber + "]";
	}
	
	
}
