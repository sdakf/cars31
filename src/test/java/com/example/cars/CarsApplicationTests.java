package com.example.cars;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

class CarsApplicationTests {

	@Test
	void contextLoads() {
		String result = "";
		for (int i = 0; i < 1000; i++) {
			result = result + i;
		}

		Date date = new Date();
		LocalDate localDate = LocalDate.now();

	}

}
