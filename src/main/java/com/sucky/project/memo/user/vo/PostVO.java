package com.sucky.project.memo.user.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sucky.project.memo.user.dao.PostDAO;
import com.sucky.project.memo.user.model.Post;

@Service
public class PostVO {
	
	
	@Autowired
	private PostDAO postDAO;
	public int addPost(int id,String subject, String content) {
		
		return postDAO.insertPost(id,subject, content);
	}
	
	public List<Post> getPost(int userId){
		
		return postDAO.selectPostList(userId);
	}
}
