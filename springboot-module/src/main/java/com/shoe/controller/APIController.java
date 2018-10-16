package com.shoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoe.dto.User;

@RestController
@RequestMapping("/api")
public class APIController {

	@RequestMapping("/getList")
	public List<User> getList(){
		List<User> list = new ArrayList<>();
		list.add(new User("JUG","456"));
		list.add(new User("YUI","456"));
		return list;
	}
}
