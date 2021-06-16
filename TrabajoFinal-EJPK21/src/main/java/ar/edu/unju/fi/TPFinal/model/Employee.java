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

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeNumber")
	private Integer employeeNumber;
	
	@Column(name = "lastName")
	private String lastName; //tamaño 50
	
	@Column(name = "firstName")
	private String firstName; //tamaño 50
	
	@Column(name = "extension")
	private String extension; // tamaño 10
	
	@Column(name = "email")
	private String email; // tamaño 100
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "officeCode")
	private Office officeCode; //tamaño 10
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "reportsTo")
	private Employee reportsTo; 
	
	@Column(name = "jobTitle")
	private String jobTitle; //tamaño50
	
	@OneToMany(mappedBy = "salesRepEmployeeNumber",fetch = FetchType.EAGER)
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
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}


	
	
}
