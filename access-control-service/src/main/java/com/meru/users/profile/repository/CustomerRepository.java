package com.meru.users.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.meru.users.profile.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	
	CustomerEntity findByCustomerId(Long customerId);

}
