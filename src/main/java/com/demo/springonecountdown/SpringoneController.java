package com.demo.springonecountdown;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class SpringoneController {

@RequestMapping("/")

  public String index() {
    CountDown countdown = new CountDown();
    return "Spring One is happening in "+countdown+"!";
  }

}
