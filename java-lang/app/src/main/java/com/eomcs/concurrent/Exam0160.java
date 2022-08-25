package com.eomcs.concurrent;

public class Exam0160 {

  public static void main(String[] args) {

    int count = 1000;

    class MyThread extends Thread {

      // 컴파일러가 바깥 메서드의 count 변수 값을 담을 수 있도록 필드를 자동으로 생성한다.
      //      int count; 

      // 컴파일러가 
      //      public MyThread(int count) { 
      //        this.count = count;
      //      }

      @Override
      public void run() {
        for (int i = 0; i < count; i++) {
          System.out.println("==> " + i);
        }
      }
    }

    // 컴파일러가 MyThread 생성자를 호출할 때 count 변수 값을 넘기는
    // 코드를 자동으로 생성할 것이니 개발자가 직접 넘길 필요가 없다.
    //
    //    new MyThread(count).start();
    new MyThread().start();

    for (int i = 0; i < count; i++) {
      System.out.println(">>> " + i);
    }
  }

}





