package com.sample.restapidemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.restapidemo.model.Addition;
import com.sample.restapidemo.model.AdditionResponse;

@Controller
public class MainController {

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String ViewForm(Model model) {
		model.addAttribute("Addition", new Addition());
		return "index";
	}

	/**
	 * 
	 * @param addition
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/addition")
	public String addForm(@ModelAttribute Addition addition, BindingResult result, Model model) {
		System.out.println(" Hello World..");
		model.addAttribute("addition", addition);
		return "calculate";
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	@GetMapping("/addition/return/integer/{num1}/{num2}")
	@ResponseBody
	public int performAdditionReturnInt(@PathVariable int num1, @PathVariable int num2) {
		System.out.println(" Received inputs are ==> " + num1 + " And " + num2);
		return num1 + num2;
	}

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	@GetMapping("/addition/return/string/{num1}/{num2}")
	@ResponseBody
	public String performAdditionReturnString(@PathVariable int num1, @PathVariable int num2) {
		System.out.println(" Received inputs are ==> " + num1 + " And " + num2);
		int result = num1 + num2;
		return String.valueOf(result);
	}

	/**
	 * 
	 * @param addEntityObj
	 * @return
	 */
	@GetMapping("/addition/return/request/entity")
	@ResponseBody
	public String performAdditionRequestObject(@RequestBody Addition addEntityObj) {
		System.out.println(" Received inputs are ==> " + addEntityObj.getNum1() + " And " + addEntityObj.getNum2());
		int result = addEntityObj.getNum1() + addEntityObj.getNum2();
		return String.valueOf(result);
	}

	/**
	 * 
	 * @param addEntityObj
	 * @return
	 */
	@GetMapping("/addition/return/response/entity")
	@ResponseBody
	public ResponseEntity<AdditionResponse> performAdditionResponseObject(@RequestBody Addition addEntityObj) {
		System.out.println(" Received inputs are ==> " + addEntityObj.getNum1() + " And " + addEntityObj.getNum2());
		String result = String.valueOf(addEntityObj.getNum1() + addEntityObj.getNum2());

		// see here how to populate responses using new response entity
		AdditionResponse adRespObj = new AdditionResponse();
		adRespObj.setAdditionResult(result);
		return ResponseEntity.ok(adRespObj);

	}
}
