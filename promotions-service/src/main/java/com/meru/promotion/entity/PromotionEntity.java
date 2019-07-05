package com.meru.promotion.entity;

import java.sql.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;



@Entity
@Table(name="promotion_tbl")
@Component
public class PromotionEntity {
	
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private Long promoId;
	@Embedded
	@NotNull
	private Product product;
	//assume pricing engine talks to other services to come up with below data and decides final_price
	private float discountPercent;
	private Date createDate;
	private Date validFromDate;
	private Date validUntilDate;
	private String minmumAllowedOrder;
	private String promotionDescription;
	
	
	
	public Long getPromoId() {
		return promoId;
	}
	public void setPromoId(Long promoId) {
		this.promoId = promoId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(float discountPercent) {
		this.discountPercent = discountPercent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getValidFromDate() {
		return validFromDate;
	}
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}
	public Date getValidUntilDate() {
		return validUntilDate;
	}
	public void setValidUntilDate(Date validUntilDate) {
		this.validUntilDate = validUntilDate;
	}
	public String getMinmumAllowedOrder() {
		return minmumAllowedOrder;
	}
	public void setMinmumAllowedOrder(String minmumAllowedOrder) {
		this.minmumAllowedOrder = minmumAllowedOrder;
	}
	public String getPromotionDescription() {
		return promotionDescription;
	}
	public void setPromotionDescription(String promotionDescription) {
		this.promotionDescription = promotionDescription;
	}
	
	
}
