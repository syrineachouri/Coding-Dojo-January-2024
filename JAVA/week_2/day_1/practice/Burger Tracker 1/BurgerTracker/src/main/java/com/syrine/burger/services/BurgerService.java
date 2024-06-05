package com.syrine.burger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.syrine.burger.models.Burger;
import com.syrine.burger.repositories.BurgerRepository;



@Service
public class BurgerService {
	private final BurgerRepository burgerRepo;
	
	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
	}
	
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	
	public Burger addBurger (Burger burger) {
		return burgerRepo.save(burger);
	}

}
