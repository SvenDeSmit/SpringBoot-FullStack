package be.sven.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.sven.fullstack.dataaccess.Car;
import be.sven.fullstack.dataaccess.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepo;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		Iterable<Car> res = carRepo.findAll();
		return res;
		
	}

}
