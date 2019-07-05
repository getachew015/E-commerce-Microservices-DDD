package com.meru.users.profile.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
	
	private String title;
	private String firstName;
	private String lastName;
	
	public Name(){
		
	}
	public Name(String title, String firstName, String lastName) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Name [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
