package com.rudysorto.carrocompras;

import java.io.FileReader;
import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CarroComprasCuscatlanApplication {

	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com Objective: Entry point to the
	 * application
	 */
	public static void main(String[] args) {
		SpringApplication.run(CarroComprasCuscatlanApplication.class, args);
	}

	/*
	 * Author: Rudy Sorto rudy.eli.ayala@gmail.com Objective: ModelMapper it's a
	 * dependency used to perform DTO Way to use it: This bean will be used in the
	 * controller to perform the DTO display
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
