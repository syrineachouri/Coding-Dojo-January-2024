package com.syrine.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.syrine.savetravels.models.Travel;
import com.syrine.savetravels.repositories.TravelRepository;


@Service
public class TravelService {
private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	public List<Travel> allTravels() {
		return travelRepo.findAll();
	}
	
	public Travel addTravel (Travel travel) {
		return travelRepo.save(travel);
	}
	//edit 
		public Travel updateTravel(Travel travel) {
			return travelRepo.save(travel);
		}
		
		//READ ONE 
		public Travel findTravelById(Long id) {
			Optional<Travel> optTravel = travelRepo.findById(id);
			if(optTravel.isPresent()) {
				return optTravel.get();
			}
			return null;
		}
		//delete 
		 public void deleteTravel(Long id) {
				travelRepo.deleteById(id);
			}
		 //find one
		 public Travel findTravelByID(Long id) {
		     Optional<Travel> optionalTravel = travelRepo.findById(id);
		     if(optionalTravel.isPresent()) {
		         return optionalTravel.get();
		     } else {
		         return null;
		     }
		 }
   }



