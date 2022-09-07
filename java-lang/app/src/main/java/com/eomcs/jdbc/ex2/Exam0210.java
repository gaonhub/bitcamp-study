// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// 1) Board 객체를 만든다.
// 2) 사용자에게 입력받을 Scanner를 준비한다.
// 3) 이 클래스에서 try블럭 두 개를 사용한다.
// 3) 제목 내용을 입력받는다.
// 4) 입력 확인을 받는다.
// 5) BoardDao를 생성한다.
// 6) 입력 성공을 출력한다.
// 7) catch에서 프린트스택트레이스를 사용한다.
package com.eomcs.jdbc.ex2;

import java.util.Scanner;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    Board board = new Board();

    try(Scanner keyscan = new Scanner(System.in)) {
      System.out.print("제목?");
      board.setTitle(keyscan.nextLine());

      System.out.print("내용?");
      board.setContent(keyscan.nextLine());

      System.out.print("입력하시겠습니까?(y/n)");
      String input = keyscan.nextLine();

      if(!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소하였습니다.");
        return;
      }
    }

    try {
      BoardDao boardDao = new BoardDao();
      int count = boardDao.insert(board);
      System.out.printf("%s개 입력 성공!", count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


