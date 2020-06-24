package com.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.api.model.Contact;


public interface ContactsRepo extends JpaRepository<Contact, Integer>{
	


}
