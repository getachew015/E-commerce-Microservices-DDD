package com.meru.pricing_engine.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meru.pricing_engine.entity.PricingEntity;
import com.meru.pricing_engine.entity.Product;


@Component
public class PricingEngine {
	
	@Autowired
	private PricingEntity pricingEntity;
	
	public PricingEntity createPrice(Product productRef){
		
		BigDecimal productCost = new BigDecimal(Math.random()*1000);
		BigDecimal myPrice = productCost.multiply(new BigDecimal(0.05)).add(productCost);
		BigDecimal cheapestCompetitorPrice = myPrice.subtract(myPrice.multiply(new BigDecimal(0.003)));
		BigDecimal highestCompetitorPrice = myPrice.add(myPrice.multiply(new BigDecimal(0.004)));
		BigDecimal average = myPrice.add(cheapestCompetitorPrice).add(highestCompetitorPrice).divide(new BigDecimal(3.00),2, RoundingMode.HALF_EVEN);
		BigDecimal finalPrice;
		
		if(myPrice.compareTo(average)==-1)
			finalPrice = average;
		else
			finalPrice=myPrice;
		
		pricingEntity.setProduct(productRef);
		pricingEntity.setProductCost(roundDecimal(productCost));
		pricingEntity.setMyPrice(roundDecimal(myPrice));
		pricingEntity.setCheapestCompetitorPrice(roundDecimal(cheapestCompetitorPrice));
		pricingEntity.setAverage(roundDecimal(average));
		pricingEntity.setHighestCompetitorPrice(roundDecimal(highestCompetitorPrice));
		pricingEntity.setFinalPrice(roundDecimal(finalPrice));
		
		return pricingEntity;
	}
	
	public BigDecimal roundDecimal(BigDecimal price){
		price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return price;
	}

}
