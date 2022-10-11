package com.ecommerce.ecom;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.ecom.models.Car;
import com.ecommerce.ecom.models.Owner;
import com.ecommerce.ecom.repository.CarRepository;
import com.ecommerce.ecom.repository.OwnerRepository;

@SpringBootApplication
public class EcomApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(EcomApplication.class);

	//jab other package ki file ka present class m use ho tab autowiredka use karate
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	//this is main method 
	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
		System.out.println("Server started, You can check it...!!");

	}

	// agar command line ke throw extra code run karwan ho to

	@Override
	public void run(String... args) throws Exception {
		// create owner and save into databse

		Owner owner1 = new Owner("Deepak", "Lodha");
		Owner owner2 = new Owner("Somil", "Agrawal");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		// add car object and link to owneers and save in the db

		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Ford2", "Mustang2", "Red2", "ADF-1121", 2022, 59000, owner2);
		Car car3 = new Car("Ford3", "Mustang3", "Red3", "ADF-11212", 2023, 59000, owner1);
		Car car4 = new Car("Ford4", "Mustang4", "Red4", "ADF-11213", 2024, 59000, owner2);
		Car car5 = new Car("Ford5", "Mustang5", "Red5", "ADF-11214", 2025, 59000, owner2);
		Car car6 = new Car("Ford6", "Mustang6", "Red6", "ADF-11215", 2026, 59000, owner2);
		repository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6));

		// agar car ko terminal m print karwana ho to

		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + "" + car.getModel());
		}
	}

}
