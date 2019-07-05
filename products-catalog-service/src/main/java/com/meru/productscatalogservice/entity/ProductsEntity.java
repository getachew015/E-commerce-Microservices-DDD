package com.meru.productscatalogservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products_tbl")
public class ProductsEntity {
	
	@Id
	private Long productId;
	private String productName;
	private String productDescription;
	private String department;
	private String category;
	private String subCategory;
	private String units;
	
	public ProductsEntity() {
		super();
	}
	
	public ProductsEntity(Long productId, String productName, String productDescription, String department,
			String category, String subCategory, String units) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.department = department;
		this.category = category;
		this.subCategory = subCategory;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	
}
