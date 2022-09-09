// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
// delete 사용
// 1) Scanner를 통해 사용자로부터 번호를 입력받는다.
// 2) BoardDao 객체를 생성하여 delete 수행하고 여부를 출력한다.
package com.eomcs.jdbc.ex3;

import java.util.Scanner;

public class Exam0450 {

  public static void main(String[] args) throws Exception {
    int no = 0;
    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호?");
      no = Integer.parseInt(keyScan.nextLine());
    }

    try {
      BoardDao boardDao = new BoardDao();
      int count = boardDao.delete(no);

      if (count == 0) {
        System.out.println("해당 번호의 게시글이 존재하지 않습니다");
      } else {
        System.out.println("삭제하였습니다");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


