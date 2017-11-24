package service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "service.rest.api", "service.rest.service" })
@EnableJpaRepositories("service.rest.repository")
public class MockMarketFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockMarketFlowApplication.class, args);
    }

}
