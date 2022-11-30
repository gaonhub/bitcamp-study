package com.bitcamp;

import java.util.Scanner;

public class Algorithm{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int year = in.nextInt();
    in.close();

    if((year % 4 == 0) || (year % 100 != 0) && (year % 400 == 0)){
      System.out.println("1");
    } else{
      System.out.println("0");
    }
  }
}