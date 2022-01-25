package com.sucky.project.memo.user.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sucky.project.common.EncryptUtils;
import com.sucky.project.memo.user.dao.UserDAO;
import com.sucky.project.memo.user.model.User;

@Service
public class UserVO {
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(String loginId, String password, String name, String email) {
		
		// 암호화 
		String encPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encPassword, name, email);
	}
	
	public User getUser(String loginId, String password) {
		
		String encPassword = EncryptUtils.md5(password);
		return userDAO.selectUser(loginId, encPassword);
	}
}
