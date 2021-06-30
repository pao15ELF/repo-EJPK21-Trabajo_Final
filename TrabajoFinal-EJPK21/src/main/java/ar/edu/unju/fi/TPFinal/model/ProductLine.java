package ar.edu.unju.fi.TPFinal.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Entity
@Table(name="PRODUCTLINES")
@Component
public class ProductLine {
	
	@Id
	@NotNull(message = "La linea de producto no puede ser nulo")
	@Column(name = "productline")
	private String productLine; //tamaño 50
	
	@Size(max = 4000, message="La descripcion se pasa de los 4000 caracteres permitidos.")
	@Column(name = "textDescription", length=4000, nullable=true)
	private String textDescription; // tamaño 4000 
	
	@Size(max = 200, message="La direccion se pasa de los 200 caracteres permitidos.")
	@Column(name = "htmlDescription", length=200, nullable=true)
	private String htmlDescription; //Preguntar con respecto a MEDIUMTEXT
	
	@Column(name = "image")
	private Blob image;  //Averiguar 
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "productLine" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	public ProductLine ()
	{
		
	}
	

	

	/**
	 * @param productLine
	 * @param textDescription
	 * @param htmlDescription
	 * @param image
	 * @param status
	 */
	public ProductLine(@NotNull(message = "La linea de producto no puede ser nulo") String productLine,
			@Size(max = 4000, message = "La descripcion se pasa de los 4000 caracteres permitidos.") String textDescription,
			@Size(max = 200, message = "La direccion se pasa de los 200 caracteres permitidos.") String htmlDescription,
			Blob image, String status) {
		
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
		this.status = status;
	}




	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}


	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}


	/**
	 * @return the textDescription
	 */
	public String getTextDescription() {
		return textDescription;
	}


	/**
	 * @param textDescription the textDescription to set
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}


	/**
	 * @return the htmlDescription
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}


	/**
	 * @param htmlDescription the htmlDescription to set
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	
	/**
	 * @return the image
	 */
	public Blob getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Blob image) {
		this.image = image;
	}


	
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}


	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
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
		return "ProductLine [productLine=" + productLine + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + ", status=" + status + "]";
	}


		
}
