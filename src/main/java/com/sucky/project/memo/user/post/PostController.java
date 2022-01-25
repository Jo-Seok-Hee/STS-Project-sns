package com.sucky.project.memo.user.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping("/post/list_view")
	public String listView() {
		return "/user/postList";
	}
}
