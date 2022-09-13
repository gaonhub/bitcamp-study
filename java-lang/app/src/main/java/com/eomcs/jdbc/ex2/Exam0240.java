// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// update 사용
// Board 객체를 생성한다.
// 사용자에게 입력받을 Scanner를 준비한다.
// 번호 제목 내용을 입력받아 setter를 통해 저장한다.
// BoardDao 객체를 생성한다.
// 변경 유무를 출력한다.
package com.eomcs.jdbc.ex2;

import java.util.Scanner;

public class Exam0240 {

  public static void main(String[] args) throws Exception { 
    Board board = new Board();

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호?");
      board.setNo(Integer.parseInt(keyScan.nextLine()));

      System.out.print("제목?");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용?");
      board.setContent(keyScan.nextLine());
    }

    try {
      BoardDao boardDao = new BoardDao();
      int count = boardDao.update(board);

      if (count == 0) {
        System.out.println("해당 번호의 게시글이 존재하지 않습니다");
      } else {
        System.out.println("변경되었습니다");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


