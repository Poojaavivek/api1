package api1.api1.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api1.api1.model.Api1Response;
import api1.api1.model.Users;
import api1.api1.service.UserService;
@RestController
@RequestMapping("/api1")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Api1Response> getUserById(@PathVariable Long id) {
	return new ResponseEntity<Api1Response>(userService. getSingleUser(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Api1Response> addUser(@Valid  @RequestBody Users user) {
	return new ResponseEntity<Api1Response>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Api1Response> updateUser( @RequestBody @Valid Users user) {
	return new ResponseEntity<Api1Response>(userService.updateUser(user), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Api1Response> deleteUser(@PathVariable("id") Long id){
	return new ResponseEntity<Api1Response>(userService.deleteUser(id), HttpStatus.OK);
	}	
}