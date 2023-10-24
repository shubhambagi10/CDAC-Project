package com.Sarthi.services;

import java.util.List;

import com.Sarthi.controller.model.User;


public interface AdminService {

	List<User> getAllDetails(); 
	
	void deleteUserById(Long id);
}
