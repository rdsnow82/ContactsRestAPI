package com.rest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


	@Entity
	@Table(name="address")
	public class Address {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		@JsonIgnore
	    private int id;
		
		
	    private String street;
	    private String city;
	    private String state;
	    private String zip;
	 
	    @OneToOne(mappedBy = "address")
	    private Contact contact;
	    
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
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
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		
		@Override
		public String toString() {
			return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
		}		
	
}
