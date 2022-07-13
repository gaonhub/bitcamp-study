// 게시판 상세보기 페이지 - 번호,제목,내용,조회수,작성자,등록일 출력
package com.bitcamp.board;

public class BoardDetailApp {

  public static void main(String[] args) {
    System.out.println("[게시판 상세보기]");

    System.out.printf("번호: %d\n", 1);
    System.out.printf("제목: %s\n", "제목입니다1.");
    System.out.printf("내용: %s\n", "내용입니다1.");
    System.out.printf("조회수: %d\n", 30);
    System.out.printf("작성자: %s\n", "홍길동");
    System.out.printf("등록일: %s\n", "2022-07-13");

  }
}