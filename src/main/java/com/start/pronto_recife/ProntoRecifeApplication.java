package com.start.pronto_recife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProntoRecifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProntoRecifeApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Hello World!";
	}
}
