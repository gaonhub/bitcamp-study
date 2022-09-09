// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// findBy 사용
// 1) Scanner를 사용해 사용자에게 번호를 입력받는다.
// 2) BaordDao 객체를 생성하고 findby를 사용하여 board 객체에 값을 저장한다.
// 3) 값을 출력한다.
package com.eomcs.jdbc.ex3;

import java.util.Scanner;

public class Exam0430 {

  public static void main(String[] args) throws Exception {
    String no = null;
    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호?");
      no = keyScan.nextLine();
    }
    try {
      BoardDao boardDao = new BoardDao();
      Board board = boardDao.findBy(no);

      if (board != null) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("등록일: %s\n", board.getRegisteredDate());
        System.out.printf("조회수: %d\n", board.getViewCount());
      } else {
        System.out.println("해당 번호의 게시글이 존재하지않습니다");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


