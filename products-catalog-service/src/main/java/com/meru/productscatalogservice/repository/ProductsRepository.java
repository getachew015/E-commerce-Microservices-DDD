package com.meru.productscatalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meru.productscatalogservice.entity.ProductsEntity;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
	
	ProductsEntity findByProductId(Long productId);
	List<ProductsEntity> findByDepartment(String department);
	List<ProductsEntity> findByDepartmentAndCategory(String department, String category);
	List<ProductsEntity> findByDepartmentAndCategoryAndSubCategory(String department, String category, String subCategory);

}
