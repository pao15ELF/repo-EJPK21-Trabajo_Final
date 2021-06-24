package ar.edu.unju.fi.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "PRODUCTS")
@Component
public class Product {
	
	@Id
	@NotNull(message = "El codigo del producto no puede ser nulo. Ingrese un codigo")
	@Column(name = "productCode")
	private String productCode; //tamaño 15 PRINCIPAL
	
	@NotEmpty(message="Debe ingresar el nombre del producto")
	@Column(name = "productName", length=70, nullable=false)
	private String productName; //tamaño 70
	
	@Valid
	@NotNull(message = "Debe ingresar una marca de producto")
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "productLine")
	private ProductLine productLine; //tamaño 50
	
	@NotEmpty(message="Debe ingresar la escala del producto")
	@Column(name = "productScale", length=10, nullable=false)
	private String productScale; //tamaño 10
	
	@NotEmpty(message="Debe ingresar nombre del vendedor del producto")
	@Column(name = "productVendor", length=50, nullable=false)
	private String productVendor; //tamaño 50
	
	@NotEmpty(message="Debe ingresar la descripcion del producto")
	@Column(name = "productDescription", length=100, nullable=false)
	private String productDescription; // text en la base
	
	@Min(value=0, message="EL minimo del producto en Stock debe ser mayor a 0")
	@Column(name = "quantityInStock", nullable=false)
	private short quantityInStock; // (por Smalint en mysql)
	
	@Min(value=0, message="EL minimo del precio de compra del producto debe ser mayor a 0")
	@Column(name = "buyPrice", nullable=false)
	private double buyPrice;//precio de compra(bigDecimal)
	
	@Min(value=0, message="EL minimo del precio sugerido de venta del producto debe ser mayor a 0")
	@Column(name = "MSRP", nullable=false)
	private double MSRP; //precio de venta sugerido por el fabricante(bigDecimal)
	
	
	public Product()
	{
		
	}
	
	

	/**
	 * @param productCode
	 * @param productName
	 * @param productLine
	 * @param productScale
	 * @param productVendor
	 * @param productDescription
	 * @param quantityInStock
	 * @param buyPrice
	 * @param mSRP
	 */
	public Product(String productCode, String productName, ProductLine productLine, String productScale,
			String productVendor, String productDescription, short quantityInStock, double buyPrice, double mSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		MSRP = mSRP;
	}



	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	

	/**
	 * @return the productLine
	 */
	public ProductLine getProductLine() {
		return productLine;
	}



	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}



	/**
	 * @return the productScale
	 */
	public String getProductScale() {
		return productScale;
	}

	/**
	 * @param productScale the productScale to set
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	/**
	 * @return the productVendor
	 */
	public String getProductVendor() {
		return productVendor;
	}

	/**
	 * @param productVendor the productVendor to set
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the quantityInStock
	 */
	public short getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * @return the buyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the mSRP
	 */
	public double getMSRP() {
		return MSRP;
	}

	/**
	 * @param mSRP the mSRP to set
	 */
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	
	
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP="
				+ MSRP + "]";
	}

	
	
}
