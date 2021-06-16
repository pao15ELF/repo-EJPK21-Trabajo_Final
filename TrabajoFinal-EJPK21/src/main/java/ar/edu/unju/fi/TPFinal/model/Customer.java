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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerNumber")
	private Integer customerNumber;
	
	@Column(name = "customersName")
	private String customerName; //tamaño 50
	
	@Column(name = "contactLastName")
	private String contactLastName; // tamaño 50
	
	@Column(name = "contactFirstName")
	private String contactFirstName; // tamaño 50
	
	@Column(name = "phone")
	private String phone; //tamaño 50
	
	@Column(name = "addressLine1")
	private String addressLine1; // tamaño 50
	
	@Column(name = "addressLine2")
	private String addressLine2; // tamaño 50
	
	@Column(name = "city")
	private String city; //tamaño 50
	
	@Column(name = "state")
	private String state; // tamaño 50
	
	@Column(name = "postalCode")
	private String postalCode; //tamaño 15
	
	@Column(name = "country")
	private String country; //tamaño 50
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salesRepEmployeeNumber")
	private Employee salesRepEmployeeNumber;
	
	@Column(name = "creditLimit")
	private double creditLimit;
	
	@OneToOne(mappedBy = "paymentId.customersNumber",fetch = FetchType.LAZY)
	private Payment payment;
	
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
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}



	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
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
