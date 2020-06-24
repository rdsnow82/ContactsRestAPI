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
@Table(name = "name")
public class Name {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int id;
	
	private String first;
	private String middle;
	private String last;
	
	@OneToOne(mappedBy = "name")
    private Contact contact;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}


	@Override
	public String toString() {
		return "Name [first=" + first + ", middle=" + middle + ", last=" + last + "]";
	}
	
	
}
