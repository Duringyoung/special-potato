package com.hxzy.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hxzy.springboot.entity.User;

@RestController
public class UserController {
	@GetMapping("hello")
	public String hello() {
		return "Sping Boot";
	}
	
	@PostMapping("login")
	public ModelAndView login(@ModelAttribute User user,ModelAndView mav) {
		if(user.getUsername().equals("admin") && user.getPassword().equals("123")) {
			mav.addObject(user);
			mav.setViewName("info");
		}
		return mav;
	}
	
	@GetMapping("login.html")
	public ModelAndView goLogin(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
	
	@GetMapping("list")
	public ModelAndView list(ModelAndView mav) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		mav.addObject("list",list);//取名为了list.ftl识别
		mav.setViewName("list");
		return mav;
		
	}
}	
