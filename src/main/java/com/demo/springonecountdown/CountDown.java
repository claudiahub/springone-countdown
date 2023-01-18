package com.demo.springonecountdown;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown {
  
  Timer timer;

  public CountDown() {
    timer = new Timer();
    timer.schedule(new GetTimer(), 0, 1000);
  }

  public class GetTimer extends TimerTask {

    // countdown duration (seconds)
    int duration = 60;

    public void run() {
      if (duration > 0) {
        duration--;
        duration + " seconds"
      }else{
        return "now";
      }
    }
  }

}