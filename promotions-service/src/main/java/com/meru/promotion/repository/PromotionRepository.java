package com.meru.promotion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.meru.promotion.entity.PromotionEntity;


@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {
	
	@Query("select p from PricingEntity p where p.product.productId=:productId")
	PromotionEntity searchByProductId(@Param("productId") Long productId);
	List<PromotionEntity> searchByProductCategory(String productCategory);
}
