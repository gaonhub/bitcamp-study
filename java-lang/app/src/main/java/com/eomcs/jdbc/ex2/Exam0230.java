// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// findBy 사용
// 1) 사용자에게 번호를 입력받을 Scanner를 준비한다.
// 2) 입력 받은 번호를 String 변수에 저장한다.
// 3) BoardDao를 생성한다.
// 4) findbyNo 메서드를 실행하여 board객체에 저장한다.
// 5) 게시물의 정보를 출력한다.

package com.eomcs.jdbc.ex2;

import java.util.Scanner;

public class Exam0230 {

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
        System.out.printf("작성일: %s\n", board.getRegisteredDate());
        System.out.printf("조회수: %d\n", board.getViewCount());
      } else {
        System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


