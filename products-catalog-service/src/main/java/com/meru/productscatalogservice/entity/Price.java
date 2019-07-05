package com.meru.productscatalogservice.entity;

import java.math.BigDecimal;
import javax.persistence.Embedded;
import org.springframework.stereotype.Component;

@Component
public class Price {
	
	private Long pricingId;
	@Embedded
	private ProductRef product;
	private BigDecimal productCost;
	private BigDecimal myPrice;
	private BigDecimal cheapestCompetitorPrice;
	private BigDecimal average;
	private BigDecimal highestCompetitorPrice;
	private BigDecimal finalPrice;
	
	public Price(){
		
	}

	public Price(ProductRef product, BigDecimal productCost, BigDecimal myPrice,
			BigDecimal cheapestCompetitorPrice, BigDecimal average, BigDecimal highestCompetitorPrice,
			BigDecimal finalPrice) {
		super();
		this.product = product;
		this.productCost = productCost;
		this.myPrice = myPrice;
		this.cheapestCompetitorPrice = cheapestCompetitorPrice;
		this.average = average;
		this.highestCompetitorPrice = highestCompetitorPrice;
		this.finalPrice = finalPrice;
	}
	
	public Long getPricingId() {
		return pricingId;
	}

	public void setPricingId(Long pricingId) {
		this.pricingId = pricingId;
	}

	public ProductRef getProduct() {
		return product;
	}
	public void setProduct(ProductRef product) {
		this.product = product;
	}
	public BigDecimal getProductCost() {
		return productCost;
	}
	public void setProductCost(BigDecimal productCost) {
		this.productCost = productCost;
	}
	public BigDecimal getMyPrice() {
		return myPrice;
	}
	public void setMyPrice(BigDecimal myPrice) {
		this.myPrice = myPrice;
	}
	public BigDecimal getCheapestCompetitorPrice() {
		return cheapestCompetitorPrice;
	}
	public void setCheapestCompetitorPrice(BigDecimal cheapestCompetitorPrice) {
		this.cheapestCompetitorPrice = cheapestCompetitorPrice;
	}
	public BigDecimal getAverage() {
		return average;
	}
	public void setAverage(BigDecimal average) {
		this.average = average;
	}
	public BigDecimal getHighestCompetitorPrice() {
		return highestCompetitorPrice;
	}
	public void setHighestCompetitorPrice(BigDecimal highestCompetitorPrice) {
		this.highestCompetitorPrice = highestCompetitorPrice;
	}
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}
	
}
