package com.all.access.model;
import java.util.Date;

public class Products 
{
	int productId;
	String productTitle;
	float price;
	Date productManufacturingDate;
	float vat;
	float discount;
	int Stock;
	
	public Products() {}
	
	public Products(int productId, String productTitle, float price, Date productManufacturingDate, float vat,
			float discount, int stock) {
		this.productId = productId;
		this.productTitle = productTitle;
		this.price = price;
		this.productManufacturingDate = productManufacturingDate;
		this.vat = vat;
		this.discount = discount;
		Stock = stock;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getProductManufacturingDate() {
		return productManufacturingDate;
	}

	public void setProductManufacturingDate(Date productManufacturingDate) {
		this.productManufacturingDate = productManufacturingDate;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}
	
	
	
	
}
