package com.harsh.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.service.IntoPostService;

@RestController
@CrossOrigin("*")
public class controller {
	
	private IntoPostService intoPostService;
	@Autowired
	public controller(IntoPostService intoPostService) {
		super();
		this.intoPostService = intoPostService;
	}
	
	@GetMapping("/calc/{s}")
	public String getPostFix(@PathVariable String s) {
		String ans = intoPostService.getAnswer(s);
		return ans;
	}
	
}
