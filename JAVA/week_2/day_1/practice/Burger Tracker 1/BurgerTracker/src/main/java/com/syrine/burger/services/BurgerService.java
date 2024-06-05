package com.syrine.burger.services;

import java.util.List;
import java.util.Optional;

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
	//edit 
		public Burger updateBurger(Burger burger) {
			return burgerRepo.save(burger);
		}
		
		//READ ONE 
		public Burger findBurgerById(Long id) {
			Optional<Burger> optBurger = burgerRepo.findById(id);
			if(optBurger.isPresent()) {
				return optBurger.get();
			}
			return null;
		}

}
