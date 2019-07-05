package com.meru.productscatalogservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.meru.productscatalogservice.entity.Price;
import com.meru.productscatalogservice.entity.ProductRef;


//@FeignClient(name="pricing-engine-service")
@FeignClient(name="api-gateway-server")
@RibbonClient(name="pricing-engine-service")
public interface PricingServiceProxy {
	
	@PostMapping("/pricing-engine-service/pricing-service/product")
	public ResponseEntity<Price> createPrice(@RequestBody ProductRef productRef);


}
