package com.sucky.project.memo.user.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sucky.project.common.FileManagerService;
import com.sucky.project.memo.user.dao.PostDAO;
import com.sucky.project.memo.user.model.Post;

@Service
public class PostVO {
	
	@Autowired
	private PostDAO postDAO;
	
	public int addPost(int userId, String subject, String content, MultipartFile file) {
		
		//파일을 서버에 저장하고, 브라우저가 접근 가능한 주소를 생성
		String filePath = FileManagerService.saveFile(userId, file);
		
		return postDAO.insertPost(userId, subject, content, filePath);
	}
	
	public List<Post> getPost(int userId){
		
		return postDAO.selectPostList(userId);
	}
	
	public Post getPostContent(int postId) {
		return postDAO.selectPostId(postId);
	}
	
	public int deletePost(int postId) {
		Post post = postDAO.selectPostId(postId);
		FileManagerService.removeFile(post.getImagePath());
		return postDAO.deletePost(postId);
	}
}
