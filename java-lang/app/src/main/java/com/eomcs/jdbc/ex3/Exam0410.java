// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// insert 사용
// 1) Board 객체 생성
// 2) Scnnaer를 통해 사용자로부터 제목 내용을 입력받는다.
// 3) insert를 사용하여 입력 개수 성공을 출력한다.
package com.eomcs.jdbc.ex3;

import java.util.Scanner;

public class Exam0410 {

  public static void main(String[] args) throws Exception {
    Board board = new Board();

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("제목?");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용?");
      board.setContent(keyScan.nextLine());

      System.out.print("입력하시겠습니까? (y/n)");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소하였습니다");
        return;
      }
    }

    try {
      BoardDao boardDao = new BoardDao();
      int count = boardDao.insert(board);
      System.out.printf("%d개 입력 완료!", count);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


