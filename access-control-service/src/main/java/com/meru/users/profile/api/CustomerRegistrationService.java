package com.meru.users.profile.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meru.users.profile.entity.CustomerEntity;
import com.meru.users.profile.repository.CustomerRepository;

@RestController
public class CustomerRegistrationService {
		
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping("/user-profile/user/{customerId}")
	public CustomerEntity getCustomerById(@PathVariable String customerId){
		//should implement id validation
		return customerRepository.findByCustomerId(Long.parseLong(customerId));
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerEntity customer){
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{customerId}")
				.buildAndExpand(addCustomer(customer)).toUri();
		return ResponseEntity.created(location).build();
	}
	
	public Long addCustomer(CustomerEntity customer){
		if(customer.getCustomerId()==null)
			customer.setCustomerId(Math.round(Math.random()*99999));
		customerRepository.saveAndFlush(customer);
		return customer.getCustomerId();
	}
	

}
