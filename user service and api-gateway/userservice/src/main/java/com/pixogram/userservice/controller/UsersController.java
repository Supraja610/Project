package com.pixogram.userservice.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.pixogram.userservice.service.AuthoritiesService;
import com.pixogram.userservice.service.IUserServices;
import com.pixogram.userservice.entity.Users;
import com.pixogram.userservice.exception.UserErrorResponse;
import com.pixogram.userservice.exception.UserNotFoundException;
import com.pixogram.userservice.model.DataModel;
import com.pixogram.userservice.model.UserOutput;
import com.pixogram.userservice.service.Userservices;

@RestController
public class UsersController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserServices userServices;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@GetMapping("/users")
	public ResponseEntity<DataModel> getall(){
		DataModel data = new DataModel();
		data.setUsers(this.userServices.getall());
		ResponseEntity<DataModel> result = new ResponseEntity<DataModel>(data, HttpStatus.OK);
		return result;
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserOutput> getById(@PathVariable Integer userId){
		UserOutput user = new UserOutput();
		Users record = new Users();
		Optional<Users> users = this.userServices.getWithId(userId);
		if(users.isPresent())
			record = users.get();
		else {
			throw new UserNotFoundException("User not found");
		}
		user.setId(record.getId());
		user.setUsername(record.getUserName());
		user.setDob(record.getDob());
		user.setFname(record.getFirstName());
		user.setLname(record.getLastName());
		user.setPassword(record.getPassword());
		user.setUemail(record.getEmail());
		user.setProfile(record.getProfile());
		ResponseEntity<UserOutput> result = new ResponseEntity<UserOutput>(user, HttpStatus.OK);
		return result;
	}
	
	//save new user
	@PostMapping("/users")
	public boolean save(@RequestBody UserOutput user) {
		
		// this.userServices.saveuser(user);
		return true;
		
	}
	
	//update user
	@PutMapping("/users")
	public boolean update(@RequestBody UserOutput user) {
		
		this.userServices.updateuser(user);
		return true;
		
	}
	
	@ExceptionHandler  // ~catch
	public ResponseEntity<UserErrorResponse> productOperationErrorHAndler(Exception ex) {
		// create error object
		UserErrorResponse error = new UserErrorResponse(ex.getMessage(), 
															  HttpStatus.BAD_REQUEST.value(), 
															  System.currentTimeMillis());
		ResponseEntity<UserErrorResponse> response =
										new ResponseEntity<UserErrorResponse>(error, HttpStatus.NOT_FOUND);
		logger.error("Exception :" + error);
		
		return response;
	}


}
