package com.sucky.project.memo.user.post;

import java.util.HashMap;
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
public class PostRestController {
	
	@Autowired
	private PostVO postVO;
	
	@PostMapping("/post/create")
	public Map<String, String> postCreate(
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			
			HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		
		// 현재 로그인된 사용자의 user table id(pk)
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postVO.addPost(userId, subject, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;	
	}
}