package com.syrine.ninjagoldgame.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaGoldController {
	@RequestMapping("/activities")
	public String activities () {
		return "activities.jsp";
	}
	@RequestMapping("/")
	public String index (
			HttpSession session,
			@RequestParam(value="farm", required = false) String farm 
			) {
	int gold = 0; 
	ArrayList<String> activities = new ArrayList<String>();
	if(session.getAttribute("gold")==null) {
	   session.setAttribute("gold", gold);
	   session.setAttribute("activities", activities);
	}else {
		gold = (int) session.getAttribute("gold");
		activities = (ArrayList<String>) session.getAttribute("activities");
	}
	
	
	if (farm != null) {	
		int amount = new Random() .nextInt(11)+10;
		gold+=amount; 
		activities.add(0,"you entred a farm and earned "+amount+"gold.");
		session.setAttribute ("activities", activities) ;
		session.setAttribute("gold", gold);
		
		return "redirect:/";
	}
	return "index.jsp";
	}
}
