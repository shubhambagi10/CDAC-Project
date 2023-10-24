package com.Sarthi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sarthi.controller.model.User;
import com.Sarthi.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public List<User> getAllDetails() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}


	@Override
	public void deleteUserById(Long id) {
		
		adminRepository.deleteById(id);
	}
	


}
