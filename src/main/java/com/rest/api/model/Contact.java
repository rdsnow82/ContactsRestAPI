package com.rest.api.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "name_id", referencedColumnName = "id")
	private Name name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "contact_id")
	private List<Phone> phone;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + "]";
	}

	
	

}
