// FileInputStream: read() 사용법
package com.bitcamp.study;

import java.io.FileInputStream;

public class Test04_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test4.data");

    int b;
    while ((b = in.read()) != -1) {
      System.out.printf("%08x\n", b);
    }

    in.close();

    System.out.println("실행 완료!");
  }

}
