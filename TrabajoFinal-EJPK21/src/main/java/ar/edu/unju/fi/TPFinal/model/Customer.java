package ar.edu.unju.fi.TPFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "CUSTOMERS")
@Component
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerNumber")
	private Integer customerNumber;
	
	@NotEmpty(message="Debe ingresar el nombre del cliente")
	@Column(name = "customersName", length=50, nullable= false)
	private String customerName; //tamaño 50
	
	@NotEmpty(message="Debe ingresar el apellido del contacto")
	@Column(name = "contactLastName" , length=50, nullable=false)
	private String contactLastName; // tamaño 50
	
	@NotEmpty(message="Debe ingresar el nombre del contacto")
	@Column(name = "contactFirstName", length=50 , nullable=false)
	private String contactFirstName; // tamaño 50
	
	@NotEmpty(message="Debe ingresar el número de telefono del cliente")
	@Column(name = "phone", length=50, nullable =false)
	private String phone; //tamaño 50
	
	@NotEmpty(message="Debe ingresar la dirección del cliente")
	@Column(name = "addressLine1", length=50 , nullable=false)
	private String addressLine1; // tamaño 50
	
	@Column(name = "addressLine2", length=50, nullable=true)
	private String addressLine2; // tamaño 50
	
	@NotEmpty(message="Debe ingresar la cuidad del cliente ")
	@Column(name = "city", length=50, nullable=false)
	private String city; //tamaño 50
	
	@Column(name = "state", length=50, nullable=true)
	private String state; // tamaño 50
	
	@Column(name = "postalCode", length=15, nullable=true)
	private String postalCode; //tamaño 15
	
	@NotEmpty(message="Debe ingresar el pais del cliente")
	@Column(name = "country", length=50, nullable=false)
	private String country; //tamaño 50
	
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salesRepEmployeeNumber")
	private Employee salesRepEmployeeNumber;
	
	@Min(value=0 , message="El limite de credito debe ser mayor o igual a 0")
	@Column(name = "creditLimit")
	private double creditLimit;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "customerNumber",fetch = FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();
	
	public Customer()
	{
		
	}

	

	/**
	 * @param customerNumber
	 * @param customerName
	 * @param contactLastName
	 * @param contactFirstName
	 * @param phone
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param state
	 * @param postalCode
	 * @param country
	 * @param salesRepEmployeeNumber
	 * @param creditLimit
	 */
	public Customer(Integer customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, Employee salesRepEmployeeNumber, double creditLimit) {
	
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}



	/**
	 * @return the customerNumber
	 */
	public Integer getCustomerNumber() {
		return customerNumber;
	}





	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}





	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}





	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}





	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}





	/**
	 * @param contactLastName the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}





	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}





	/**
	 * @param contactFirstName the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}





	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}





	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}





	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}





	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}





	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}





	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}





	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}





	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}





	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}





	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}





	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}





	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}





	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}





	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @return the salesRepEmployeeNumber
	 */
	public Employee getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}



	/**
	 * @param salesRepEmployeeNumber the salesRepEmployeeNumber to set
	 */
	public void setSalesRepEmployeeNumber(Employee salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}



	/**
	 * @return the creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}


	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	
	



	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}



	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
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



	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + ", salesRepEmployeeNumber="
				+ salesRepEmployeeNumber + ", creditLimit=" + creditLimit + "]";
	}


}
