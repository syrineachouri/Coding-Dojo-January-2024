package com.syrine.daikichipv.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	
	@GetMapping("/daikichi/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	
	@GetMapping("/daikichi/lotto/{number}")
	public String lottoEven(@PathVariable("number") int number) {
		if (number%2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend with family and friends";
		}
	}
}
