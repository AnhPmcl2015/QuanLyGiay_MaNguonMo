package com.shoe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoe.dao.StudentDAO;
import com.shoe.dao.SubjectDAO;
import com.shoe.dto.SubjectDTO;

@Controller
@RequestMapping("/Home")
public class HomeController {
	@Autowired
	private StudentDAO studentDao;

	@Autowired
	private SubjectDAO subjectDao;

	@GetMapping
	public String goHome(Map<String, Object> model) {
		model.put("studentlist", studentDao.getListStudent());
		return "home";
	}

	@RequestMapping("/addStudent")
	public String goAddStudent() {
		List<SubjectDTO> list = subjectDao.getListSubject();
		for (SubjectDTO subject : list) {
			System.out.println(subject.getMamonhoc() + " " + subject.getStudent().getFullname());
		}
		return "addStudent";
	}
}
