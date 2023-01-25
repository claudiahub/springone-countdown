package com.demo.springonecountdown;

import java.time.Duration;
import java.time.ZoneId;
import java.util.Properties;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.HashMap;
import org.springframework.http.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin("*")
@RequestMapping("/api")
public class SpringoneCountDown {

	public static void main(String[] args) {
		SpringApplication.run(SpringoneCountDown.class, args);
	}

	public static String getCountDown() {
		// ZoneId zoneId = ZoneId.of( "America/Chicago" );
		// ZonedDateTime now = ZonedDateTime.now( zoneId );
		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		ZonedDateTime springOneStartDate = ZonedDateTime.parse("2023-01-25 17:00:00 +01:00", formatter);
		// Duration duration = Duration.between( now , springOneStartDate );
		// int countdown = (int) Math.floor(duration.toHours());
		return springOneStartDate.toString();
	}

	@GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, String> springOne() {

	    HashMap<String, String> entity = new HashMap<String, String>();
	    entity.put("title", "Spring One happens in");
	    entity.put("date", getCountDown().toString());
		return entity;
   }
}
