package com.Sarthi.services;

import com.Sarthi.controller.model.User;


public interface UserServices {

	public User createUser(User user);
	
	   public boolean checkEmail(String email);


		public boolean checkPassword(String password);

		public User getUserByEmailAndPassword(String email, String password);
}
