package com.sucky.project.memo.user.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sucky.project.memo.user.model.Post;
import com.sucky.project.memo.user.vo.PostVO;

@Controller
public class PostController {
	
	@Autowired
	private PostVO postVO;
	
	@GetMapping("/post/postView")
	public String listView() {
		return "/post/createView";
	}
	
	@GetMapping("/post/listView")
	public String postView(HttpServletRequest request,Model model) {
		
		HttpSession session =  request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> postList = postVO.getPost(userId);
		model.addAttribute("postList", postList);
		
		
		return "/post/postList";
		
	}
	
	@GetMapping("/post/listContentView")
	public String listContentView(@RequestParam("postId")int postId,Model model) {
		
		Post post = postVO.getPostContent(postId);
		model.addAttribute("post", post);
		
		
		
		return "/post/postListContent";
	}
}
