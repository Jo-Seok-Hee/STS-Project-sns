package com.sucky.project.memo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {
	
	

	@GetMapping("/user/signup_view")
	public String signupView() {
		return "/user/signUp";
	}
	
	@GetMapping("/user/memo")
	public String signInView() {
		return "/user/signIn";
	}
	
	@GetMapping("/user/signout")
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		return "redirect:/user/memo";
	}
}
