package com.meru.pricing_engine.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meru.pricing_engine.entity.PricingEntity;
import com.meru.pricing_engine.entity.Product;
import com.meru.pricing_engine.repository.PricingRepository;
import com.meru.pricing_engine.utility.PricingEngine;

@RestController
@RequestMapping("/pricing-service")
public class PricingService {
	
	@Autowired
	PricingRepository pricingRepository;
	@Autowired
	PricingEngine pricingEngine;

	PricingEntity pricingEntity;
	
	
	@PostMapping("/product")
	public ResponseEntity<PricingEntity> createPrice(@RequestBody Product productRef){
				
		pricingEntity = pricingEngine.createPrice(productRef);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{productId}").buildAndExpand(addPrice(pricingEntity)).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/product/{productId}")
	public PricingEntity findPriceByProductId(@PathVariable String productId){
		PricingEntity pricingEntity =
				pricingRepository.searchByProductId(Long.parseLong(productId));
		return pricingEntity;
	}
	
	public Long addPrice(PricingEntity pricingEntity){
		pricingRepository.saveAndFlush(pricingEntity);
		return pricingEntity.getProduct().getProductId();
	}

}
