package org.springframework.boot.boursemarketgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockMarketGenBApplication {

	public static void main(String[] args) {

		SpringApplication.run(StockMarketGenBApplication.class, args);
	}
}
