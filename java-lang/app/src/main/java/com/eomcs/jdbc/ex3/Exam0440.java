// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// update 사용
// 1) Board 객체를 생성한다.
// 2) Scanner를 통해 번호, 제목, 내용을 입력받은 후 board에 저장한다.
// 3) BoardDao 객체를 생성한다.
// 4) update를 수행하고 변경 여부를 출력한다.

package com.eomcs.jdbc.ex3;

import java.util.Scanner;

public class Exam0440 {

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
        System.out.println("변경하였습니다");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


