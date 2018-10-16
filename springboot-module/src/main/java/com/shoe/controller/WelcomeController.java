package com.shoe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shoe.dto.SubjectDTO;
import com.shoe.dto.User;

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
	@RequestMapping("/giay")
	public ModelAndView gotoGiay(Map<String, Object> model) {
		model.put("message", this.message);
		return new ModelAndView("giay");
	}
	@RequestMapping("/dsgiay")
	public ModelAndView gotoDsGiay(Map<String, Object> model) {
		model.put("message", this.message);
		return new ModelAndView("danhsachgiay");
	}
	@RequestMapping("/searchgiay")
	public ModelAndView gotoTraCuuGiay(Map<String, Object> model) {
		model.put("message", this.message);
		return new ModelAndView("tracuugiay");
	}
	@GetMapping("/getData")
	public List<String> dataFromReact(@RequestParam("email") String email) {
		List<String> list = new ArrayList<>();
		list.add(email);		
		return list;
	}
	@RequestMapping(value="/sendData", consumes="application/json",  method = RequestMethod.POST)
	public List<String> getJson(@RequestBody User user) {
		List<String> list = new ArrayList<>();
		list.add(user.getUsername()+" yui");
		return list;
	}
}