package ar.edu.unju.fi.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ORDERDETAILS")
@Component
public class OrderDetail {


	@EmbeddedId
	@Autowired
	private OrderDetailId orderDetailId;
	
	@Min(value=1, message="La cantidad minima a ordenar debe ser mayor o igual a 1")
	@Column(name = "quantityOrdered", nullable=false)
	private int quantityOrdered;
	
	@Min(value=0, message="El precio unitario del producto deber ser mayor 0 ")
	@Column(name = "priceEach", nullable=false)
	private double priceEach; 
	
	@Min(value=0, message="El número de linea de orden debe ser mayor a 0")
	@Column(name = "orderLineNumber", nullable=false)
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
		return "OrderDetail [ quantityOrdered=" + quantityOrdered + ", priceEach="
				+ priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}
	
	
}
