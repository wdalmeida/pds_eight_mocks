package org.springframework.boot.boursemarketgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.boursemarketgenerator.generator.DoubleGenerator;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigInteger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@SpringBootApplication
@EnableScheduling
public class BourseMarketGenerator {



	public static void main(String[] args) {

		SpringApplication.run(BourseMarketGenerator.class, args);
	}

}
