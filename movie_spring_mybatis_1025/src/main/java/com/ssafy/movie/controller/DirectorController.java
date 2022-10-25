package com.ssafy.movie.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.movie.dto.Director;
import com.ssafy.movie.service.DirectorService;


@RequestMapping("/director")
@Controller
public class DirectorController {

	private DirectorService directorService;
	@Autowired
	public void setDirectorService(DirectorService directorService) {
		this.directorService = directorService;
	}
	
	@GetMapping("/registerForm")
	public String addForm() {
		return "register";
	}
	@PostMapping("/register")
	public String addDirector(Director director) {
		directorService.addDirector(director);
		return "redirect:/director/list";
	}

	@PostMapping("/modify")
	public String modifyDirector(Director director) {
		directorService.modifyDirector(director);
		return "redirect:/director/list";
	}
	
	@PostMapping("/remove")
	public String removeDirector(String id) {
		directorService.removeDirector(id);
		return "redirect:/director/list";
	}

	@GetMapping("/detail")
	public String findDirector(String id,Model model) {
//		model.addAttribute("director",directorService.findDirector(id));
		model.addAttribute("director",directorService.findDirectorWithMovieList(id));
		return "detail";
	}

	@GetMapping("/list")
	public String findDirectorList(Model model) {
		model.addAttribute("directorList",directorService.findDirectorList());
		return "list";
	}
	
	@PostMapping("/search")
	public String findDirectorWithMultiCondition(@RequestParam HashMap<String, Object> conditions, Model model) {
		model.addAttribute("directorList", directorService.findDirectorWithMultiCondition(conditions));
		return "list";
		
	}
	
	
	@PostMapping("/search2")
	public String findDirectorWithMultiCondition(@RequestParam String name, @RequestParam String age, Model model ) {
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		if(!name.equals("")) {
			conditions.put("name", name);
		}
		if(!age.equals("")) {
			conditions.put("age", Integer.parseInt(age));
		}
		model.addAttribute("directorList", directorService.findDirectorWithMultiCondition(conditions));

		return "list";
		
	}
}
