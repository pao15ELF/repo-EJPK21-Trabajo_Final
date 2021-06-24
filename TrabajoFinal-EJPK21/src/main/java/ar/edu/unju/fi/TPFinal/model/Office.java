package ar.edu.unju.fi.TPFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "OFFICES")
@Component
public class Office {

	@Id
	@NotNull(message = "Debe ingresar un codigo de officina")
	@Column(name = "officeCode")
	private String officeCode; //10
	
	@NotEmpty(message="Debe ingresar la cuidad de la oficina")
	@Column(name = "city", length=50, nullable=false)
	private String city; // 50
	
	@NotEmpty(message="Debe ingresar el telefono de la oficina")
	@Column(name = "phone", length=50, nullable=false)
	private String phone; //50
	
	@NotEmpty(message="Debe ingresar la direccion de la oficina")
	@Column(name = "addressLine1", length=50, nullable=false)
	private String addressLine1; //50
	
	@Column(name = "addressLine2", length=50, nullable=true)
	private String addressLine2; //50
	
	@Column(name = "state", length=50, nullable=true)
	private String state; //50
	
	@NotEmpty(message="Debe ingresar el pais de la oficina")
	@Column(name = "country", length=50, nullable=false)
	private String country; // 50
	
	@NotEmpty(message="Debe ingresar el codigo postal de la oficina")
	@Column(name = "postalCode", length=15, nullable=false)
	private String postalCode; //15
	
	@NotEmpty(message="Debe ingresar el territorio")
	@Column(name = "territory", length=10, nullable=false)
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