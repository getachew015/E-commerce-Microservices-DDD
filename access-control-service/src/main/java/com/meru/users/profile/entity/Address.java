package com.meru.users.profile.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String addressType;
	private String streetAddress;
	private String suite;
	private String city;
	private String state;
	private String zipCode;
	
	public Address(){
		
	}
	public Address(String addressType, String streetAddress, String suite, String city, String state,
			String zipCode) {
		super();
		this.addressType = addressType;
		this.streetAddress = streetAddress;
		this.suite = suite;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "AddressEntity [addressType=" + addressType + ", streetAddress=" + streetAddress + ", suite=" + suite
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	

}
