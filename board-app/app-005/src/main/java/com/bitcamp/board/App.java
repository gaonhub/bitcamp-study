package com.bitcamp.board;

public class App {
  public static void main(String[] args) {
      System.out.println("[게시판 애플리케이션]");
      System.out.println();
      System.out.println("환영합니다!!");
      System.out.println();

      java.util.Scanner keyboardInput = new java.util.Scanner(System.in);
      
      final int SIZE = 3;

      int[] no = new int[SIZE];
      String[] title = new String[SIZE];
      String[] content = new String[SIZE];
      String[] writer = new String[SIZE];
      String[] password = new String[SIZE];
      int[] viewCount = new int[SIZE];
      long[] createdDate = new long[SIZE];

      int boardCount = 0;

      while (true) {
      System.out.println("메뉴:");
      System.out.println("  1: 게시물 목록");
      System.out.println("  2: 게시물 상세보기");
      System.out.println("  3: 게시물 등록하기");
      System.out.println();
      System.out.print("메뉴를 선택하세요[1..3] (0:종료)");

      int menuNum = keyboardInput.nextInt();
      keyboardInput.nextLine();

      System.out.println("-----------------------------------------");

      if (menuNum == 0) {
        break;

      } else if (menuNum == 1) {
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
       
        for (int i = 0; i < boardCount; i++) {
          java.util.Date date = new java.util.Date(createdDate);

          String dateStr = formatter.format(date);
          System.out.printf("%d\t%s\t%d\t%s\t%s\n", no[i], title[i], viewCount[i], writer[i], dateStr);
          System.out.println();
        }

      } else if (menuNum == 2) {
        System.out.println("[게시판 상세보기]");

        System.out.println("조회할 게시글 번호?");
        String input = keyboardInput.nexLine();
        int boardNo = Integer.parseInt(input);
        System.out.printf("번호: %d\n", no);
        System.out.printf("제목: %s\n", title);
        System.out.printf("내용: %s\n", content);
        System.out.printf("조회수: %d\n", viewCount);
        System.out.printf("작성자: %s\n", writer);

        java.util.Date date = new java.util.Date(createdDate);
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
        System.out.println();

      } else if (menuNum == 3) {
        if (boardCount == SIZE) {
          System.out.println("게시글을 더이상 등록할 수 없습니다.");
          continue;
        }
        
        System.out.println("게시물 등록");
        
        System.out.print("제목? ");
        title[boardCount] = keyboardInput.nextLine();

        System.out.print("내용? ");
        content[boardCount] = keyboardInput.nextLine();

        System.out.print("작성자? ");
        writer[boardCount] = keyboardInput.nextLine();

        System.out.print("암호? ");
        password[boardCount] = keyboardInput.nextLine();

        no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;
        viewCount[boardCount] = 0;
        createdDate[boardCount] = System.currentTimeMillis();

        boardCount ++;

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    } // while

    System.out.println("안녕히 가세요!!");
    keyboardInput.close();

  }
}
