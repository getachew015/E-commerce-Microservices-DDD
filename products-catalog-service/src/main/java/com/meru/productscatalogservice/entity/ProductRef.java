package com.meru.productscatalogservice.entity;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;


@Embeddable
@Component
public class ProductRef{
	
	private Long productId;
	private String productName;
	private String productDescription;
	private String units;
	
	//Product Ref data used to call pricing API
	public ProductRef(){
		
	}
	public ProductRef(Long productId, String productName, String productDescription, String units) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.units = units;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	
	
}
