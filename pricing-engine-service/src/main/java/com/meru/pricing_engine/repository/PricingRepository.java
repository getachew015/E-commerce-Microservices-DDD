package com.meru.pricing_engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.meru.pricing_engine.entity.PricingEntity;

@Repository
public interface PricingRepository extends JpaRepository<PricingEntity, Long> {
	
	@Query("select p from PricingEntity p where p.product.productId=:productId")
	PricingEntity searchByProductId(@Param("productId") Long productId);

}
