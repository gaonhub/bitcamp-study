package com.eomcs.concurrent;

public class Exam0240 {

  public static void main(String[] args) {

    class MyRunnable implements Runnable {

      int count;

      public MyRunnable(int count) {
        this.count = count;
      }

      @Override
      public void run() {

        for (int i = 0; i < count; i++) {
          System.out.println("==> " + i);
        }
      }
    }

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


