package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class CosmosController {

	private final ReservationRepository reservationRepository;

	private int counter = 0;

	public CosmosController(ReservationRepository rr) {
		reservationRepository = rr;
	}

	@GetMapping("/hello-world")
	String helloWorld() {
		reservationRepository.save(new Reservation(null, "Test azure cosmos " + counter++));

		return reservationRepository.findAll()
				.stream()
				.map(Reservation::getName)
				.collect(Collectors.joining());
	}
}

interface ReservationRepository extends MongoRepository<Reservation, String> {}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Reservation{
	@Id
	private String id;
	private String name;
}
