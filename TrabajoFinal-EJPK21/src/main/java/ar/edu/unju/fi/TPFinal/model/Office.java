package ar.edu.unju.fi.TPFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OFFICES")
public class Office {

	@Id
	@Column(name = "officeCode")
	private String officeCode; //10
	
	@Column(name = "city")
	private String city; // 50
	
	@Column(name = "phone")
	private String phone; //50
	
	@Column(name = "addressLine1")
	private String addressLine1; //50
	
	@Column(name = "addressLine2")
	private String addressLine2; //50
	
	@Column(name = "state")
	private String state; //50
	
	@Column(name = "country")
	private String country; // 50
	
	@Column(name = "postalCode")
	private String postalCode; //15
	
	@Column(name = "territory")
	private String territory; //10
	
	@OneToMany(mappedBy = "officeCode")
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Office()
	{
		
	}

	public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	
	public String getAddressLine2() {
		return addressLine2;
	}

	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	
	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public String getPostalCode() {
		return postalCode;
	}

	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}
	
	
	
}