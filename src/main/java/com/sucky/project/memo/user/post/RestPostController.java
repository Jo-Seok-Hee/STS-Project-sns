package com.sucky.project.memo.user.post;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sucky.project.memo.user.model.User;
import com.sucky.project.memo.user.vo.PostVO;

@RestController
public class RestPostController {
	
	@Autowired
	private PostVO postVO;
	
	@PostMapping("/post/create")
	public Map<String, String> create(
			
			@RequestParam("subject")String subject
			, @RequestParam("content")String content
			,
			
		
