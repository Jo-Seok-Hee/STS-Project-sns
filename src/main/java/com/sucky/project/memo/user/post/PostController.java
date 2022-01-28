package com.sucky.project.memo.user.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping("/post/postView")
	public String listView() {
		return "/user/createView";
	}
	
	@GetMapping("/post/listView")
	public String postView(HttpServletRequest request) {
		
		HttpSession session =  request.getSession();
		
		
		return "/user/postList";
	}
}
