package com.demo.confcountdown;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConfCountDownController {

  ZoneId zoneId = ZoneId.of( "America/Chicago" );
  ZonedDateTime now = ZonedDateTime.now( zoneId );
  DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
  ZonedDateTime springOneStartDate = ZonedDateTime.parse("2023-01-25 17:00:00 +01:00", formatter);
  Duration duration = Duration.between( now , springOneStartDate );
  int countdown = (int) Math.floor(duration.toHours());

  @GetMapping("/*")

  public String index() {
    return "SpringOne happens in "+countdown+" hours!";
  }

}
