package com.eomcs.concurrent;

public class Exam0220 {

  public static void main(String[] args) {

    int count = 1000;

    //    MyRunnable r = new MyRunnable(count);
    //    Thread t = new Thread(r);
    //    t.start();

    //    Thread t = new Thread(new MyRunnable(count));
    //    t.start();

    new Thread(new MyRunnable(count)).start();

    for (int i = 0; i < count; i++) {
      System.out.println(">>> " + i);
    }
  }
}


