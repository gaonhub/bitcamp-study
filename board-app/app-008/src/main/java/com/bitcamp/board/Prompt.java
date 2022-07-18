package com.bitcamp.board;

public class Prompt {
  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  static int intInput() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static int intInput(String title) {
    System.out.print(title);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static String intputString() {
    return keyboardInput.nextLine();
  }

  static String inputString(String title) {
    System.out.print(title);
    return keyboardInput.nextLine();
  }

  static void close() {
    keyboardInput.close();
  }

}
