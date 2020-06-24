package com.rest.api.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.api.dao.ContactsRepo;
import com.rest.api.model.Contact;

@RestController
public class ContactController {

	@Autowired
	ContactsRepo repo;
	
	@PostMapping(path="/contacts", consumes = {"application/json"})
	public ResponseEntity<?> addContact(@RequestBody @Valid Contact contact) {
		
		try {
		
		repo.save(contact);
		
		}
		catch (ConstraintViolationException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(contact, HttpStatus.CREATED);
	}
	
	
    @PutMapping(path="/contacts/{id}", consumes= {"application/json"})
	public ResponseEntity<?> updateContact(@PathVariable int id, @RequestBody @Valid Contact updatedContact) {
		
		Optional <Contact> contact = repo.findById(id);
	
		
		if (contact.isPresent()) {
			Contact _contact = contact.get();
			
			updatedContact.setId(id);
			updatedContact.getAddress().setId(_contact.getAddress().getId());
			updatedContact.getName().setId(_contact.getName().getId());
				
			try {
				
				return new ResponseEntity<>(repo.save(updatedContact), HttpStatus.OK);
			}
			catch (Exception ex) {
				return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseEntity<>("Unable to upate. Contact with id " + id + " not found.",
                HttpStatus.NOT_FOUND);
		
	}
	
	
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable int id) {
		
		if (!repo.existsById(id)) {
			return new ResponseEntity<>("Unable to delete.  Contact with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}
		
		repo.deleteById(id);
		return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	
	}
	
	
	@GetMapping(path="/contacts", produces= {"application/json"})
	public ResponseEntity<List<Contact>> getContacts()
	{
		List<Contact> contacts = repo.findAll();
		if (contacts.isEmpty()) {
			return new ResponseEntity<>(contacts, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}
	
	
	@GetMapping(path="/contacts/{id}", produces= {"application/json"})
	public ResponseEntity<?> getContact(@PathVariable("id") int id)
	{
		Optional <Contact> contact = repo.findById(id);
		if (!contact.isPresent()) {
			return new ResponseEntity<>("Contact with id " + id  + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact, HttpStatus.OK);
		
	}
	
	
	
}
