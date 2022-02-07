package com.sucky.project.memo.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sucky.project.memo.user.model.Post;

@Repository
public interface PostDAO {
	
	
	public int insertPost(
			@Param("userId") int userId, 
			@Param("subject") String subject, 
			@Param("content") String content,
			@Param("imagePath") String imagePath);
	
	public List<Post> selectPostList(@Param("userId")int userId);
	
	public Post selectPostId(@Param("postId")int postId);
	public int deletePost(@Param("postId") int postId);
}
