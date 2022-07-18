package com.bitcamp.board;

public class Prompt {
  
  static int intInput() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static int intInput(String title) {
    System.out.print(title);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static String stringInput() {
    return keyboardInput.nextLine();
  }

  static String stringInput(String title) {
    System.out.print(title);
    return keyboardInput.nextLine();
  }

  static void close() {
    keyboardInput.close();
  }

}
