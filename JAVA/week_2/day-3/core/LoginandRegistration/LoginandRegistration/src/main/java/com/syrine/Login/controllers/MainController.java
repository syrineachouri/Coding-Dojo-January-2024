package com.syrine.Login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.syrine.Login.models.User;
import com.syrine.Login.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@Autowired
	private UserService userServ;
	
	@GetMapping("/welcome")
	public String dashboard(HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		if (user_id == null) {
			return "redirect:/";
		}
		User user = userServ.findUserById(user_id);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}