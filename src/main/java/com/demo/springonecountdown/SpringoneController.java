package com.demo.springonecountdown;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class SpringoneController {

  ZoneId zoneId = ZoneId.of( "America/Chicago" );
  ZonedDateTime now = ZonedDateTime.now( zoneId );
  final static DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
  ZonedDateTime springOneStartDate = ZonedDateTime.parse("2023-01-24 17:00:00 pm", formatter);
  Duration duration = Duration.between( now , springOneStartDate );
  long countdown = duration.toHours();

  @RequestMapping("/")

  public String index() {
    return "SpringOne happens in " + Math.floor(countdown) + " hours !";
  }

}
