package com.syrine.omikujiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiController {
	@GetMapping("/")
	public String blank() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji") 
	public String index() {
		return "index.jsp";	
	}
	
	@PostMapping("/omikuji/post")
	public String post(@RequestParam(value="counter") Integer counter,
						@RequestParam(value="city") String city,
						@RequestParam(value="person") String person,
						@RequestParam(value="pursuit") String pursuit,
						@RequestParam(value="thing") String thing,
						@RequestParam(value="message") String message,
						HttpSession session) {
		session.setAttribute("counter", counter);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("pursuit", pursuit);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	} 
}
