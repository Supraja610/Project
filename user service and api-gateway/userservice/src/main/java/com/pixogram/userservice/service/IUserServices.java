package com.pixogram.userservice.service;

import java.util.List;
import java.util.Optional;

import com.pixogram.userservice.entity.Users;
import com.pixogram.userservice.model.UserInput;
import com.pixogram.userservice.model.UserOutput;

public interface IUserServices {
	
	public List<Users> getall();
	public void saveuser(UserInput userInput);
	public Optional<Users> getWithId(Integer id);
	public void updateuser(UserOutput action);
}
