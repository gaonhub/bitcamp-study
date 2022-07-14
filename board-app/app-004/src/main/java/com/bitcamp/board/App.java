package com.bitcamp.board;

public class App {
  public static void main(String[] args) {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);
    
    int boardNum = 0;
    String title = "";
    String content = "";
    String writer = "";
    String password = "";
    int viewCount = 0;
    long createdDate = 0;

    while (true) {
      System.out.println("메뉴:");
      System.out.println("  1: 게시글 목록");
      System.out.println("  2: 게시글 상세보기");
      System.out.println("  3: 게시글 등록하기");
      System.out.println();
      System.out.print("메뉴를 선택하세요[1..3](0: 종료)");
      
      int menuNum = keyboardInput.nextInt();
      keyboardInput.nextLine();
      System.out.println("-------------------------------------");

      if (menuNum == 0) {
        break;
      } else if (menuNum == 1 ) {
        System.out.println("[게시판 목록보기]");
        System.out.println("번호 제목 조회수 작성자 등록일");
  
        System.out.print(1);
        System.out.print("\t");
        System.out.print("제목입니다1");
        System.out.print("\t");
        System.out.print(20);
        System.out.print("\t");
        System.out.print("홍길동\t");
        System.out.print("2022-07-13\r\n");
  
        System.out.print(2 + "\t" + "제목입니다2" + "\t" + 30 + "\t"+ "임꺽정" + "\t" + "2022-07-13\n");
  
        System.out.println(3 + "\t제목입니다3\t" + 40 + "\t유관순" + "\t2022-07-13");
  
        System.out.printf("%d\t%s\t%d\t%s\t%s\n", 4, "제목입니다4", 50, "임가온", "2022-07-13");
        System.out.println();

      } else if (menuNum == 2 ) {
        System.out.println("[게시판 상세보기]");
  
        System.out.printf("번호: %d\n", num);
        System.out.printf("제목: %s\n", title);
        System.out.printf("내용: %s\n", content);
        System.out.printf("조회수: %d\n", viewCount);
        System.out.printf("작성자: %s\n", writer);
        
        java.util.Date date = new java.util.Date(createdDate);
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$1tM\n", date);
        System.out.println();

      } else if (menuNum == 3) {
        System.out.println("[게시글 등록]");

        System.out.println("제목?");
        title = keyboardInput.nextLine();
        System.out.println("내용?");
        content = keyboardInput.nextLine();
        System.out.println("작성자?");
        writer = keyboardInput.nextLine();
        System.out.println("암호?");
        password = keyboardInput.nextLine();

        num = 1;
        viewCount = 0;
        createdDate = System.currentTimeMillis();

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    } // while
    
    System.out.println("안녕히 가세요!!");
    keyboardInput.close();   

  }
}