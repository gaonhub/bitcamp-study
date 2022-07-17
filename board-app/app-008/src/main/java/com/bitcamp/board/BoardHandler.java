package com.bitcamp.board;

public class BoardHandler {
  static final int SIZE = 3;
  static int boardCount = 0;

  static Board[] boards = new Board[SIZE];

  static void processList() {
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

    System.out.println("[게시판 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    for (int i = 0; i < boardCount; i++) {
      Board board = boards[i];
      
      java.util.Date date = new java.util.Date(boards.createdDate);
      String dateStr = formatter.format(date);

      System.out.printf("%d\t%s\t%d\t%s\t%s\n", board.no,board.title,board.viewCount,board.writer,dateStr);
    }
  }

  static void processDetail() {
    System.out.println("[게시판 상세보기");

    int boardNo = Prompt.inputInt("조회할 번호? ");

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
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("조회수: %d\n", board.viewCount);
    java.util.Date date = new java.util.Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM", date);
  }

  static void processInput() {
    System.out.println("게시판 등록하기");

    if (boardCount == SIZE) {
      System.out.println("더이상 게시글을 등록할 수 없습니다");
      return;
    }

    Board board = new Board();

    board.title = Prompt.nextLine("제목? ");
    board.content = Prompt.nextLine("내용? ");
    board.writer = Prompt.nextLine("작성자? ");
    board.password = Prompt.nextLine("암호? ");

    board.no = boardCount == 0 ? 1 : boards[boardCount - 1].no + 1;
    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    boardCount++;

  }
}
