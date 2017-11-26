package fr.mock.eight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MarketFlowGeneratorApp {

    public static void main(String[] args) {
        SpringApplication.run(MarketFlowGeneratorApp.class, args);
    }

}
