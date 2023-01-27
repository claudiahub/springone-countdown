package com.demo.confcountdown;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import org.springframework.http.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin("*")
@RequestMapping("/api")
public class ConfCountDown extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ConfCountDown.class, args);
	}

	public static String getCountDown() {
		// ZoneId zoneId = ZoneId.of( "Europe/Barcelona" );
		// ZonedDateTime now = ZonedDateTime.now( zoneId );
		DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		ZonedDateTime startDate = ZonedDateTime.parse("2023-05-18 9:00:00 +01:00", formatter);
		// Duration duration = Duration.between( now , startDate );
		// int countdown = (int) Math.floor(duration.toHours());
		return startDate.toString();
	}

	@GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap<String, String> conf() {

	    HashMap<String, String> entity = new HashMap<String, String>();
	    entity.put("title", "Spring I/O 2023 will happen in Barcelona!");
		entity.put("date", getCountDown());
		return entity;
   }
}
