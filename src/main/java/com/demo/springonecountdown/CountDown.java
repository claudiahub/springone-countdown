package com.demo.springonecountdown;

import java.util.Timer;
import java.util.TimerTask;
public class CountDown extends TimerTask {

    // countdown duration (seconds)
    int duration = 60;
    static int interval;
    static Timer timer;

    public void run() {
      if (duration > 0) {
        duration--;
        System.out.println(duration + " seconds");
      } else {
        System.out.println("now");
      }
    }
}