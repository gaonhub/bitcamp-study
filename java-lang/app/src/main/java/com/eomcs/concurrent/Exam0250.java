package com.eomcs.concurrent;

public class Exam0250 {

  public static void main(String[] args) {

    int count = 1000;

    class MyRunnable implements Runnable {
      @Override
      public void run() {

        for (int i = 0; i < count; i++) {
          System.out.println("==> " + i);
        }
      }
    }

    new Thread(new MyRunnable()).start();

    for (int i = 0; i < count; i++) {
      System.out.println(">>> " + i);
    }
  }

}


