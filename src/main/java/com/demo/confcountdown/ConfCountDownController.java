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
  ZonedDateTime startDate = ZonedDateTime.parse("2023-05-18 17:00:00 +01:00", formatter);
  Duration duration = Duration.between( now , startDate );
  int countdown = (int) Math.floor(duration.toDays());

  @GetMapping("/*")

  public String index() {
    String conferenceName = System.getenv("conferenceName");
    return "Spring I/O will happen in "+countdown+" days!";
  }

}
