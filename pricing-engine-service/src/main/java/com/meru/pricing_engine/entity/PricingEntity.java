package com.meru.pricing_engine.entity;

import java.math.BigDecimal;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;



@Entity
@Table(name="pricing_tbl")
@Component
public class PricingEntity {
	
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private Long pricingId;
	@Embedded
	@NotNull
	private Product product;
	//assume pricing engine talks to other services to come up with below data and decides final_price
	private BigDecimal productCost;
	private BigDecimal myPrice;
	private BigDecimal cheapestCompetitorPrice;
	private BigDecimal average;
	private BigDecimal highestCompetitorPrice;
	private BigDecimal finalPrice;
	
	public PricingEntity(){
		
	}

	public PricingEntity(@NotNull Product product, BigDecimal productCost, BigDecimal myPrice,
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

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
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
