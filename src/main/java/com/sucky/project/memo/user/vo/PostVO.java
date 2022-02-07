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
	
	public int addPost(int userId, String subject, String content) {
		
		return postDAO.insertPost(userId, subject, content);
	}
	
	public List<Post> getPost(int userId){
		
		return postDAO.selectPostList(userId);
	}
	
	public Post getPostContent(int postId) {
		return postDAO.selectPostId(postId);
	}
	
	public int deletePost(int postId) {
		return postDAO.deletePost(postId);
	}
}
