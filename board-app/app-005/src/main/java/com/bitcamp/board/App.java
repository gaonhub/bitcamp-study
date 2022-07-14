package com.bitcamp.board;

public class App {

  public static void main(String[] args) {
    System.out.println("[게시판 애플리케이션");
    System.out.println();
<<<<<<< HEAD
    System.out.println("환영합니다!!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");


    final int SIZE = 4;
    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] content = new String[SIZE];
    String[] writer = new String[SIZE];
    int[] viewCount = new int[SIZE];
    long[] createdDate = new long[SIZE];
    String[] password = new String[SIZE];
    int boardCount = 0;

    while (true) {
      System.out.println("메뉴: ");
      System.out.println("  1: 게시물 목록");
      System.out.println("  2: 게시물 상세보기");
      System.out.println("  3: 게시물 작성하기");
      System.out.println();
      System.out.print("메뉴 번호를 입력하세요[1...3] (종료: 0)");
=======
    System.out.println("환영합니다!!!");
    System.out.println();

    final int SIZE = 3;
    int[] num = new int[SIZE];
    String[] title = new title[SIZE];
    String[] content = new content[SIZE];
    int[] viewCount = new viewCount[SIZE];
    String[] writer = new writer[SIZE];
    long[] createdDate = new createdDate[SIZE];
    int boardCount = 0;

    java.util.Sacnner keyboardInput = new java.util.Scanner(System.in);
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
    
    while (true) {
    System.out.println("메뉴: ");
    System.out.println("  1: 게시판 목록");
    System.out.println("  2: 게시판 상세보기");
    System.out.println("  3: 게시판 등록하기");
    System.out.println();
    System.out.print("메뉴 번호를 입력하세요.[0...3] (종료:0_");
    
    int menuNum = keyboardInput.nextInt();
    keyboardInput.nextLine();

    System.out.println("---------------------------------------");

    if (menuNum == 0) {
      break;
    } else if (menuNum == 1) {
      System.out.println("[게시판 목록]");
      System.out.println("번호 제목 내용 조회수 작성자 등록일");
>>>>>>> e8cd95cf1400fce0bb02878dee6a77066e8792fd

      for (int i = 0; i < boardCount; i ++) {
        java.util.Date date = new java.util.Date(createdDate[i]);
        String dateStr = formatter.format(date);

<<<<<<< HEAD
      System.out.println("============================================");

      if (menuNum == 0) {
        break;

      } else if (menuNum == 1) {
        System.out.println("게시물 목록");
        System.out.println("번호 제목 내용 작성자 조회수 등록일");

        for (int i = 0; i < boardCount; i++) {
          java.util.Date date = new java.util.Date(createdDate[i]);
          String dateStr = formatter.format(date);

          System.out.printf("%d\t%s\t%d\t%s\t%s\n", no[i], title[i], viewCount[i], writer[i], dateStr);
        }
      } else if (menuNum == 2) {
        System.out.println("게시물 상세보기");
        
        System.out.print("조회할 게시글 번호?");
        String input = keyboardInput.nextLine();
        int boardNo = Integer.parseInt(input);

        int boardIndex = -1;
        for(int i = 0; i < boardCount; i++) {
          if (no[i] == boardNo) {
            boardIndex = i;
            break;
          }
        }
          if (boardIndex == -1) {
          System.out.println("해당 번호의 게시글이 없습니다!");
          continue;
        }

        System.out.printf("번호: %d\n", no[boardIndex]);
        System.out.printf("제목: %s\n", title[boardIndex]);
        System.out.printf("내용: %s\n", content[boardIndex]);
        System.out.printf("조회수: %d\n", viewCount[boardIndex]);
        System.out.printf("작성자: %s\n", writer[boardIndex]);
        java.util.Date date = new java.util.Date(createdDate[boardIndex]);
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
        
      } else if (menuNum == 3) {
        System.out.println("게시물 작성하기");
        
        if (boardCount == SIZE) {
          System.out.println("게시글을 더이상 저장할 수 없습니다.");
          continue;
        }

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

        boardCount++;

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      System.out.println();
=======
        System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\n", num[i],title[i],content[i],viewCount[i],writer[i],dateStr);        
      }

    } else if (menuNum == 2) {
      System.out.println("[게시판 상세보기]");
  
      System.out print("조회할 게시글 번호? ");
      String inputNum = keyboardInput.nextLine();
      int boardNo = Integer.ParseInt(inputNum);

      int boardIndex = -1;
      for (int i = 0; i < boardCount; i++ ) {
        if (num[i] == boardNo) {
          boardIndex = i;
          break;
        }
      }

      if (boardIndex == -1) {
        System.out.println("해당 번호의 게시글이 없습니다!");
        continue;
      }

      System.out.printf("번호: %d\n", num[boardIndex]);
      System.out.printf("제목: %s\n", title[boardIndex]);
      System.out.printf("내용: %s\n", content[boardIndex]);
      System.out.printf("조회수: %d\n", viewCount[boardIndex]);
      System.out.printf("작성자: %s\n", writer[boardIndex]);
      java.util.Date date = new java.util.Date(createdDate[boardIndex]);
      System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);

    } else if (menuNum == 3) {
      System.out.println("[게시판 작성하기");
      
      if (boardCount == SIZE) {
        System.out.println("게시글을 더이상 저장할 수 없습니다.");
        continue;
      }
      System.out.print("제목? ");
      title[boardCount] = keyboardInput.nextLine();

      System.out.print("내용? ");
      content[boardCount] = keyboardInput.nextLine();

      System.out.print("작성자? ");
      writer[boardCount] = keyboardInput.nextLine();

      System.out.print("암호? ");
      password[boardCount] = keyboardInput.nextLine();

      num[boardCount] = boardCount == 0 ? 1 : num[boardCount - 1] + 1;
      viewCount[boardCount] = 0;
      createdDate[boardCount] = System.currentTimeMillis();

      boardCount++;
    } else {
      System.out.println("메뉴 번호가 옳지 않습니다!");
    }


>>>>>>> e8cd95cf1400fce0bb02878dee6a77066e8792fd

    } // while

    System.out.println("안녕히 가세요!!");
    keyboardInput.close();
<<<<<<< HEAD
=======


>>>>>>> e8cd95cf1400fce0bb02878dee6a77066e8792fd
  }
}