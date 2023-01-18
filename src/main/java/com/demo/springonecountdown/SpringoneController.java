package com.demo.springonecountdown;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class SpringoneController {

  ZoneId zoneId = ZoneId.of ( "America/NewYork" );
  ZonedDateTime now = ZonedDateTime.now ( zoneId );
  ZonedDateTime springOneStartDate = now.plusDays(10);
  Duration duration = Duration.between ( now , springOneStartDate );
  long countdown = duration.toHours();

@RequestMapping("/")

  public String index() {
    return "SpringOne happens in "+countdown+"!";
  }

}
