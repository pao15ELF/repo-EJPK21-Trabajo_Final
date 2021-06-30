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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMPLOYEES")
@Component
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeNumber")
	private Integer employeeNumber;
	
	@NotEmpty(message="Debe ingresar el apellido del empleado")
	@Column(name = "lastName", length=50, nullable=false)
	private String lastName; //tamaño 50
	
	@NotEmpty(message="Debe ingresar el nombre del empleado")
	@Column(name = "firstName", length=50, nullable=false)
	private String firstName; //tamaño 50
	
	@NotEmpty(message="Debe ingresar la extension")
	@Column(name = "extension", length=10, nullable=false)
	private String extension; // tamaño 10
	
	@Email(message="Ingrese una dirección de email valida.")
	@NotEmpty(message="Debe ingresar un correo electronico valido")
	@Column(name = "email", length=100, nullable=false)
	private String email; // tamaño 100
	
	@Autowired
	@Valid
	@NotNull(message="Debe elegir un departamento")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "officeCode")
	private Office officeCode; //tamaño 10
	
	@Autowired
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "reportsTo")
	private Employee reportsTo; 
	
	@NotEmpty(message="Debe ingresar el titulo de trabajo del empleado")
	@Column(name = "jobTitle", length=50, nullable=false)
	private String jobTitle; //tamaño50
	
	@OneToMany(mappedBy = "salesRepEmployeeNumber",fetch = FetchType.LAZY)//EAGER
	private List<Customer> customers = new ArrayList<Customer>();
	
	public Employee()
	{
		
	}

	public Employee(Integer employeeNumber, String lastName, String firstName, String extension, String email,
			Office officeCode, Employee reportsTo, String jobTitle) {
		
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Office getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Office officeCode) {
		this.officeCode = officeCode;
	}

	public Employee getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Employee reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}



	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", jobTitle=" + jobTitle + "]";
	}


	
	
}
