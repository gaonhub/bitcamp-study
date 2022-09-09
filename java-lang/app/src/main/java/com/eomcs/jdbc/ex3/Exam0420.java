// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// findAll 사용
// 1) BoardDao 객체를 생성한다.
// 2) Board타입의 리스트를 생성하여 findAll 값을 저장한다.
// 3) Board 객체를 생성하여 값을 출력한다.
package com.eomcs.jdbc.ex3;

import java.util.List;

public class Exam0420 {

  public static void main(String[] args) throws Exception {
    try {
      BoardDao boardDao = new BoardDao();
      List<Board> list = boardDao.findAll();
      System.out.println("번호, 제목, 내용, 등록일, 조회수");
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


