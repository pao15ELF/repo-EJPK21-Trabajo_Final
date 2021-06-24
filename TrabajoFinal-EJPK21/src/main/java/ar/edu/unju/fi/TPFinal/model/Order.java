package ar.edu.unju.fi.TPFinal.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ORDERS")
@Component
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderNumber")
	private Integer orderNumber;
	
	@NotNull(message="Debe ingresar la fecha de la orden ")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "orderDate", nullable=false)
	private LocalDate orderDate; 
	
	@NotNull(message="Debe ingresar la fecha de retiro de la orden ")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "requiredDate", nullable=false)
	private LocalDate requiredDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "shippedDate", nullable=true)
	private LocalDate shippedDate;
	
	@NotEmpty(message="Debe ingresar el estado de la orden")
	@Column(name = "status", length=15, nullable=false)
	private String status; //tamaño 15
	
	@Size(max=250, message="El comentario no debe pasar los 250 caracteres")
	@Column(name = "comments", length=250, nullable=true)
	private String comments; //es TEXT definir tamaño
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerNumber")
	private Customer customerNumber;
	
	@OneToOne(mappedBy = "orderDetailId.orderNumber" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private OrderDetail orderDetail;
	
	public Order()
	{
		
	}

	/**
	 * @param orderNumber
	 * @param orderDate
	 * @param requiredDate
	 * @param shippedDate
	 * @param status
	 * @param comments
	 * @param customerNumber
	 * @param orderDetail
	 */
	public Order(Integer orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippedDate, String status,
			String comments, Customer customerNumber, OrderDetail orderDetail) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
		this.orderDetail = orderDetail;
	}

	/**
	 * @return the orderNumber
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the requiredDate
	 */
	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	/**
	 * @param requiredDate the requiredDate to set
	 */
	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 * @return the shippedDate
	 */
	public LocalDate getShippedDate() {
		return shippedDate;
	}

	/**
	 * @param shippedDate the shippedDate to set
	 */
	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the customerNumber
	 */
	public Customer getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the orderDetail
	 */
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	/**
	 * @param orderDetail the orderDetail to set
	 */
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", orderDetail="
				+ orderDetail + "]";
	}
	
	
}
