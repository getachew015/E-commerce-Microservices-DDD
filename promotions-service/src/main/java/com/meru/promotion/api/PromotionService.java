package com.meru.promotion.api;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.meru.promotion.entity.PromotionEntity;
import com.meru.promotion.repository.PromotionRepository;


@RestController
@RequestMapping("/promotion-service")
public class PromotionService {
	
	@Autowired
	PromotionRepository promotionRepository;

	PromotionEntity promotionEntity;
	
	@GetMapping("/product/{productId}")
	public PromotionEntity searchByProductId(@PathVariable String productId) {
		
		promotionEntity = promotionRepository.searchByProductId(Long.parseLong(productId));
		return promotionEntity;		
	}
	
	@GetMapping("/product-category/{productCategory}")
	public List<PromotionEntity> searchByProductCategory(@PathVariable String productCategory){
		
		List<PromotionEntity> promoList = 
										promotionRepository.searchByProductCategory(productCategory);
		
		return promoList;
	}
	
	@PostMapping("/product")
	public ResponseEntity<PromotionEntity> createPromotion(@RequestBody PromotionEntity promotion){
		URI location = null;
		try {
			location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{productId}").buildAndExpand(addPromotion(promotion)).toUri();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.created(location).build();

	}
	
	public Long addPromotion(PromotionEntity promotion) throws Exception {
		
		if(promotion.getProduct().getProductId()==null)
			throw new Exception("Invalid product , no product Id provided !");
		promotionRepository.saveAndFlush(promotion);
		
		return promotion.getProduct().getProductId();
	}
	
	

}
