package com.demo.springonecountdown;

import java.util.Timer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class SpringoneController {

  Timer timer = new Timer();

@RequestMapping("/")

  public String index() {
    return "SpringOne happens in "+timer+"!";
  }

}
