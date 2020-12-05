package com.avi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.model.Contact;
import com.avi.repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

	private ContactRepository repository;

	ContactController(ContactRepository contactRepository) {
		this.repository = contactRepository;
	}

	@GetMapping
	public List<Contact> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Contact> findById(@PathVariable long id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = {"delete/{id}"})
	public String deleteById(@PathVariable long id){
		repository.deleteById(id);
		return "Successfully deleted " + id;
	}

	@PutMapping("/put/{id}")
	public Contact replaceOrAddContact(@RequestBody Contact newContact, @PathVariable Long id) {
		return repository.findById(id)
				.map(contact -> {
					contact.setfName(newContact.getfName());
					contact.setlName(newContact.getlName());
					contact.setEmail(newContact.getEmail());
					contact.setPhone(newContact.getPhone());
					contact.setStatus(newContact.getStatus());
					return repository.save(contact);
				})
				.orElseGet(() -> {
					newContact.setId(id);
					return repository.save(newContact);
				});
	}
	
	@PutMapping("/inactive/{id}")
	public Contact replaceOrAddContact(@PathVariable Long id) {
		return repository.findById(id)
				.map(contact -> {
					contact.setStatus("Inactive");
					return repository.save(contact);
				})
				.orElse(null);
	}
}
