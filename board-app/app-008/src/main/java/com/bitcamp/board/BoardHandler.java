package com.bitcamp.board;

public class BoardHandler {
  static final int SIZE = 3;
  static int boardCount = 0;

  static Board[] boards = new Board[SIZE]; 
  /* 
  static int[] no = new int[SIZE];
  static String[] title = new String[SIZE];
  static String[] content = new String[SIZE];
  static int[] viewCount = new int[SIZE];h
  static String[] writer = new String[SIZE];
  static String[] password = new String[SIZE];
  static long[] createdDate = new long[SIZE]; */

  static void processList() {
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

    System.out.println("[게시판 목록]");
    System.out.println("번호 제목 작성자 조회수 등록일");

    for (int i = 0; i < boardCount; i++) {
      Board board = boards[i];

      java.util.Date date = new java.util.Date(board.createdDate);
      String dateStr = formatter.format(date);

      System.out.printf("%d\t%s\t%s\t%d\t%s\n", board.no,board.title,board.writer,board.viewCount,dateStr);
    }    

  }

  static void processDetail() {
    System.out.println("[게시판 상세보기]");

    int boardNo = Prompt.intInput("조회할 게시글 번호? ");

    Board board = null;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %s\n", board.writer);
    java.util.Date date = new java.util.Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }

  static void processInput() {
    System.out.println("[게시판 등록하기]");

    if (boardCount == SIZE) {
      System.out.println("더이상 게시글을 등록할 수 없습니다");
      return;
    }

    Board board = new Board();

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.password = Prompt.inputString("암호? ");

    board.no = boardCount == 0 ? 1 : boards[boardCount - 1].no + 1;
    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    boards[boardCount] = board;

    boardCount++;    
  }

}
