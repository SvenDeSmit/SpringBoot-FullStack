package be.sven.fullstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.sven.fullstack.dataaccess.Car;
import be.sven.fullstack.dataaccess.CarRepository;
import be.sven.fullstack.dataaccess.Owner;
import be.sven.fullstack.dataaccess.OwnerRepository;

@SpringBootApplication
public class SpringBootFullStackApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootFullStackApplication.class);
	
	@Autowired
	private CarRepository carRepo;
	@Autowired
	private OwnerRepository ownerRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFullStackApplication.class, args);
		logger.info("Application started");
	}
	
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner own1 = new Owner("Sven","De smit");
			Owner own2 = new Owner("Sabrina","Lambrecht");
			ownerRepo.save(own1);
			ownerRepo.save(own2);
			Car car1 = new Car("Ford","Mustang","Red","ADF-1121",2017,59000,"This is my favourite car",own1);
			Car car2 = new Car("Nissan","Leaf","White","SSJ-3002",2014,29000,"This is an electric car",own2);
			Car car3 = new Car("Toyota","Prius","Silver","KKO-0212",2017,59000,"This is an hybrid car",own2);
			carRepo.save(car1);
			carRepo.save(car2);		
			carRepo.save(car3);
		};
		
	}
	

}
