package com.Sarthi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sarthi.controller.model.User;
import com.Sarthi.controller.model.feedBackDeatils;
import com.Sarthi.services.UserFeedBackService;
import com.Sarthi.services.UserServices;

import javax.servlet.http.HttpSession;

@Controller
public class UserRegistrationController {


	@Autowired
	private UserServices userService;
	
	@Autowired
	private UserFeedBackService userFeedBackService;

	
	
	@GetMapping("/Reg")
	public String Reg() {
		return "registration";
	}
	@GetMapping("/signin")   
	public String signUp() {
		return "login";
	}
	
	@GetMapping("/aboutUs")   
	public String AboutUs() {
		return "aboutUs";
	}
	
	@GetMapping("/feedback")   
	public String feedback() {
		return "feedback";
	}
	
	@GetMapping("/index")   
	public String index() {
		return "home";
	}
	@PostMapping("/registration")
	public String createUser(@ModelAttribute User user,HttpSession session) {
		
		//System.out.println(user);
		
		boolean f=userService.checkEmail(user.getEmail());
		
		System.out.print(f);
		if(f)
		{
			session.setAttribute("msg","Email ID is Already Exists");
		} 
		else
		{
			User  userDetails=userService.createUser(user);
			
			if(userDetails!=null)
			{
				session.setAttribute("msg","Register SuccessFull");
				return "redirect:/signin";
			}
			else
			{
				session.setAttribute("msg","Error on Server");
			}
			
		}
				
		return "redirect:/register";
	}
	
	 @PostMapping("/home")
	    public String loginUser(@RequestParam String email, @RequestParam String password) {
	        User user = userService.getUserByEmailAndPassword(email, password);
	        if (user != null) {
	            return "home";
	        } else {
	            return "redirect:/signin";
	        }
	    }
	 
	 @PostMapping("/feed")
		public String saveFeedBack(@ModelAttribute feedBackDeatils fBDeatils)
		{
			userFeedBackService.saveFeedBack(fBDeatils);
			
			return "home";
		
	    }
}
	

