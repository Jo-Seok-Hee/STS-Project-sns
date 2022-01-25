package com.sucky.project.memo.user;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sucky.project.memo.user.model.User;
import com.sucky.project.memo.user.vo.UserVO;

@RestController
public class UserRestController {
	@Autowired
	private UserVO userVO;
	
	@PostMapping("/user/sign_up")
	public Map<String, String> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		int count = userVO.addUser(loginId, password, name, email);
		
		// {"result":"success"} 
		// {"result":"fail"}
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	@PostMapping("/user/sign_in")
	public Map<String, String> singIn(
			
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request
			){
		
		User user = userVO.getUser(loginId, password);
		
		Map<String, String> result = new HashMap<>();
		if(user != null) {
			result.put("result","success");
			//성공시 세션 부여
			HttpSession session =  request.getSession();
			//id, loginId, name 
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			
			
			
		} else {
			result.put("result","fail");
		}
		return result;
	}
}
