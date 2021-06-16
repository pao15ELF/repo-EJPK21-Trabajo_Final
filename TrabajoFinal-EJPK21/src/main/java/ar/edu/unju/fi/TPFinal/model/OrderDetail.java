package ar.edu.unju.fi.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ORDERDETAILS")
public class OrderDetail {


	@EmbeddedId
	private OrderDetailId orderDetailId;
	
	@Column(name = "quantityOrdered")
	private int quantityOrdered;
	
	@Column(name = "priceEach")
	private double priceEach; 
	
	@Column(name = "orderLineNumber")
	private short orderLineNumber;
	
	
	public OrderDetail()
	{
		
	}


	/**
	 * @param orderDetailId
	 * @param quantityOrdered
	 * @param priceEach
	 * @param orderLineNumber
	 */
	public OrderDetail(OrderDetailId orderDetailId, int quantityOrdered, double priceEach, short orderLineNumber) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}


	/**
	 * @return the orderDetailId
	 */
	public OrderDetailId getOrderDetailId() {
		return orderDetailId;
	}


	/**
	 * @param orderDetailId the orderDetailId to set
	 */
	public void setOrderDetailId(OrderDetailId orderDetailId) {
		this.orderDetailId = orderDetailId;
	}


	/**
	 * @return the quantityOrdered
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}


	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}


	/**
	 * @return the priceEach
	 */
	public double getPriceEach() {
		return priceEach;
	}


	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}


	/**
	 * @return the orderLineNumber
	 */
	public short getOrderLineNumber() {
		return orderLineNumber;
	}


	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}


	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", quantityOrdered=" + quantityOrdered + ", priceEach="
				+ priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}
	
	
}
