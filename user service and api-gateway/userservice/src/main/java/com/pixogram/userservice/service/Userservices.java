package com.pixogram.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixogram.userservice.entity.Authorities;
import com.pixogram.userservice.entity.Users;
import com.pixogram.userservice.model.UserInput;
import com.pixogram.userservice.model.UserOutput;
import com.pixogram.userservice.repository.AuthorityRepository;
import com.pixogram.userservice.repository.UsersRepository;

@Service
public class Userservices implements IUserServices{

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	public List<Users> getall(){
		List<Users> records=this.userRepository.findAll();
		return records;
		
	}
	public Optional<Users> getWithId(Integer id){
		Optional<Users> record= this.userRepository.findById(id);
		return record;
		
	}
	
	public void saveuser(UserInput user) {
		Users data = new Users();
		//Authorities auth = new Authorities();
		//auth.setUsername(user.getUsername());
		//auth.setAuthority("ROLE_USER");
		// data.setId(user.getId());
		data.setUserName(user.getUsername());
		data.setFirstName(user.getFname());
		data.setLastName(user.getLname());
		data.setEmail(user.getUemail());
		data.setDob(user.getDob());
		data.setPassword("{noop}" + user.getPassword());
		data.setProfile(user.getProfile());
		data.setEnabled(true);
		this.userRepository.save(data);
		
		// add authority
		Authorities role = new Authorities(user.getUsername(), "ROLE_USER");
		this.authorityRepository.save(role);
	}
	
	public void updateuser(UserOutput user) {
		Users data = new Users();
		//Authorities auth = new Authorities();
		//auth.setUsername(user.getUsername());
		//auth.setAuthority("ROLE_USER");
		data.setId(user.getId());
		data.setUserName(user.getUsername());
		data.setFirstName(user.getFname());
		data.setLastName(user.getLname());
		data.setEmail(user.getUemail());
		data.setDob(user.getDob());
		data.setPassword(user.getPassword());
		data.setProfile(user.getProfile());
		data.setEnabled(true);
		this.userRepository.save(data);
	}
}
