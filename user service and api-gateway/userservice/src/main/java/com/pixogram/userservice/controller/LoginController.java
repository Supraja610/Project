package com.pixogram.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.userservice.model.ResponseData;
import com.pixogram.userservice.model.UserInput;
import com.pixogram.userservice.service.IUserServices;

@RestController
public class LoginController {
	
	// dependency
	@Autowired
	private IUserServices userService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// testing end-point
	@GetMapping("/login")
	public ResponseEntity<ResponseData> login() {
		// if called then credentials are valid
		logger.info("Logged In...");
		ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis());

		ResponseEntity<ResponseData> response = 

					new ResponseEntity<ResponseData>(data, HttpStatus.OK);
		return response;

}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseData> register(@RequestBody UserInput userInput) {
		// if called then credentials are valid
		logger.info("Registration...");
		
		this.userService.saveuser(userInput);
		
		ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis());

		ResponseEntity<ResponseData> response = 

					new ResponseEntity<ResponseData>(data, HttpStatus.OK);
		return response;

}
}