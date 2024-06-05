package com.syrine.burger.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syrine.burger.models.Burger;
import com.syrine.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService ;
	
	@GetMapping("/")
	public String burgers(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	@PostMapping("/addBurger")
	public String home(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		burgerService.addBurger(burger);
		return "redirect:/";
	}
	
	 @RequestMapping("/burger/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Burger burger = burgerService.findBurgerById(id);
	        model.addAttribute("burger", burger);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/burger/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("burger", burger);
	            return "edit.jsp";
	        } else {
	            burgerService.updateBurger(burger);
	            return "redirect:/";
	        }
	    }
	    

}
