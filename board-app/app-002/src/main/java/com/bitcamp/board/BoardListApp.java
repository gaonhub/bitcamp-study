package com.bitcamp.board;

public class BoardListApp {

  public static void main(String[] args) {
    System.out.println("[게시판 목록보기]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    System.out.print(1);
    System.out.print("\t");
    System.out.print("제목입니다1");
    System.out.print("\t");
    System.out.print(20);
    System.out.print("\t");
    System.out.print("홍길동\t");
    System.out.print("2022-07-13\r\n");

    System.out.print(2 + "\t" + "제목입니다2" + "\t" + 30 + "\t"+ "임꺽정" + "\t" + "2022-07-13\n");

    System.out.println(3 + "\t제목입니다3\t" + 40 + "\t유관순" + "\t2022-07-13");

    System.out.printf("%d\t%s\t%d\t%s\t%s\n", 4, "제목입니다4", 50, "임가온", "2022-07-13");


  }
}