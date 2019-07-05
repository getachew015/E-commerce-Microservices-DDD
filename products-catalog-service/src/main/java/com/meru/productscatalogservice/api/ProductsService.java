package com.meru.productscatalogservice.api;

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
import com.meru.productscatalogservice.entity.ProductRef;
import com.meru.productscatalogservice.entity.ProductsEntity;
import com.meru.productscatalogservice.proxy.PricingServiceProxy;
import com.meru.productscatalogservice.repository.ProductsRepository;

@RestController
@RequestMapping("/products-catalog-service")
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private ProductRef productRef;
	@Autowired
	private PricingServiceProxy pricingServiceProxy;
	
	
	@GetMapping("/product/{productId}")
	public ProductsEntity findProductById(@PathVariable String productId){
		
		ProductsEntity product = 
				(ProductsEntity)productsRepository.findByProductId(Long.parseLong(productId));
		return product;
	}

	@GetMapping("/department/{department}")
	public List<ProductsEntity> findProductByDepartment(@PathVariable String department){
		
		List<ProductsEntity> products = 
				(List<ProductsEntity>)productsRepository.findByDepartment( department);
		return products;
	}
	
	@GetMapping("/department/{department}/category/{category}")
	public List<ProductsEntity> findProductByDepartmentAndCategory(@PathVariable String department
			, @PathVariable String category){
		
		List<ProductsEntity> products = 
				(List<ProductsEntity>)productsRepository.findByDepartmentAndCategory(department, category);
		return products;
	}
	
	@GetMapping("/department/{department}/category/{category}/subCategory/{subCategory}")
	public List<ProductsEntity> findProductByDepartmentAndCategoryAndSubCategory(@PathVariable String department,
			@PathVariable String category, @PathVariable String subCategory){
		
		List<ProductsEntity> products = 
				(List<ProductsEntity>)productsRepository.findByDepartmentAndCategoryAndSubCategory(department, category, subCategory);
		
		return products;
	}
	
	@PostMapping("/product")
	public ResponseEntity<ProductsEntity> createProduct(@RequestBody ProductsEntity product){
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{productId}").buildAndExpand(addProduct(product)).toUri();

		//create a default price by calling pricing API every time a new product gets created
		productRef.setProductId(product.getProductId());
		productRef.setProductName(product.getProductName());
		productRef.setProductDescription(product.getProductDescription());
		productRef.setUnits(product.getUnits());

		pricingServiceProxy.createPrice(productRef);
		
		return ResponseEntity.created(location).build();
	}
	
	public Long addProduct(ProductsEntity product){
		if(product.getProductId()==null)
			product.setProductId(Math.round((Math.random()*1000000)));
		productsRepository.saveAndFlush(product);
		return product.getProductId();
	}
}
