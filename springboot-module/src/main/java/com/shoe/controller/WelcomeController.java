package com.shoe.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.shoe.entities.User;
import com.shoe.entities.data;

@RestController
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public ModelAndView welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return new ModelAndView("welcome");
	}
	
	@GetMapping("/getListStaff")
	@CrossOrigin
	public data getListStaff() {
		
		List<User> datalist = new ArrayList<>();
		datalist.add(new User("1","hung"));	
		datalist.add(new User("2","hung"));	
		datalist.add(new User("3","hung"));	
		datalist.add(new User("4","hung"));	
		datalist.add(new User("5","hung"));	
		datalist.add(new User("6","hung"));	
		datalist.add(new User("7","hung"));	
		datalist.add(new User("8","hung"));	
		data dt = new data();
		List user1 = datalist;
		dt.setData(user1);
		return dt;
	}
	@RequestMapping(value="/sendData", consumes="application/json",  method = RequestMethod.POST)
	public User getJson(@RequestBody User user) {
		List<String> list = new ArrayList<>();
		list.add(user.getUsername()+" "+user.getId());
		System.out.println(user);		
		return user;
	}
	@PostMapping(value = "/getData", consumes = "application/json")
	@CrossOrigin
	public void getDataGiay(@RequestBody  User model) {
		System.out.println(model.getUsername()+" "+model.getId());
		//System.out.println(model.get("maGiay") + " " + model.get("tenGiay") + " " + model.get("gioiTinh"));
	}
}