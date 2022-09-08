// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// findAll 사용
// 1) try 블록을 생성한다.
// 2) BoardDao를 생성한다.
// 3) BoardDao의 목록을 호출하여 값을 Board 타입의 List로 저장한다.
//
package com.eomcs.jdbc.ex2;

import java.util.List;

public class Exam0220 {

  public static void main(String[] args) throws Exception {
    try {
      BoardDao boardDao = new BoardDao();
      List<Board> list = boardDao.findAll();
      for (Board b : list) {
        System.out.printf("%d, %s, %s, %s, %d", 
            b.getNo(),
            b.getTitle(),
            b.getContent(),
            b.getRegisteredDate(),
            b.getViewCount());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


