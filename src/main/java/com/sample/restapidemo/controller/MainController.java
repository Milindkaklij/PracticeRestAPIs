package com.sample.restapidemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sample.restapidemo.model.Addition;

@Controller
public class MainController {

	@GetMapping("/index")
	public String ViewForm(Model model) {
		model.addAttribute("Addition", new Addition());
		return "index";
	}

	@PostMapping("/addition")
	public String addForm(@ModelAttribute Addition addition, BindingResult result, Model model) {
		System.out.println(" Hello World..");
		model.addAttribute("addition", addition);
		return "calculate";
	}
}
