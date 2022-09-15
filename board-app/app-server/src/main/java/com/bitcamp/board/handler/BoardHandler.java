/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;

public class BoardHandler {

  private BoardDao boardDao;

  public BoardHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void list(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<style>");
    out.println("tr:hover {");
    out.println("   background-color: navy;");
    out.println("   color: white;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>제목</th>");
    out.println("    <th>조회수</th>");
    out.println("    <th>작성자</th>");
    out.println("    <th>등록일</th>");
    out.println("  </tr>");

    List<Board> boards = boardDao.findAll();
    for (Board board : boards) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", board.no);
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", board.no, board.title);
      out.printf("  <td>%d</td>", board.viewCount);
      out.printf("  <td>%d</td>", board.memberNo);
      out.printf("  <td>%s</td>", board.createdDate);
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }

  public void detail(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 상세 정보</h1>");

    int boardNo = Integer.parseInt(paramMap.get("no"));
    Board board = boardDao.findByNo(boardNo);

    if (board == null) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");

    } else {
      out.println("<form action='update'>");
      out.println("<table border='1'>");
      out.println("  <tr>");
      out.printf("    <th>번호</th><td><input name='no' type='number' value='%d' readonly></td>", board.no);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>제목</th><td><input name='title' type='text' value='%s' size='60'></td>", board.title);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>내용</th><td><textarea name='content' rows='10' cols='60'>%s</textarea></td>", board.content);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>조회수</th><td>%d</td>", board.viewCount);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>작성자</th><td>%d</td>", board.memberNo);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>등록일</th><td>%s</td>", board.createdDate);
      out.println("  </tr>");
      out.println("</table>");
      out.println("<p>");
      out.println("  <button type='submit'>변경</button>");
      out.println("  <a href='delete?no=%d'>삭제</a>");
      out.println("</p>");
      out.println("</form>");
    }

    out.println("</body>");
    out.println("</html>");
  }

  public void input(Map<String,String> paramMap, PrintWriter out) throws Exception {

    //    Prompt prompt = new Prompt(in, out);
    //
    //    Board board = new Board();
    //
    //    board.title = prompt.inputString("제목? ");
    //    board.content = prompt.inputString("내용? ");
    //    board.memberNo = prompt.inputInt("작성자? ");
    //
    //    boardDao.insert(board);
    //    out.writeUTF("게시글을 등록했습니다.");
  }

  public void delete(Map<String,String> paramMap, PrintWriter out) throws Exception {

    //    Prompt prompt = new Prompt(in, out);
    //
    //    int boardNo = 0;
    //    while (true) {
    //      try {
    //        boardNo = prompt.inputInt("삭제할 게시글 번호? ");
    //        break;
    //      } catch (Exception ex) {
    //        out.writeUTF("입력 값이 옳지 않습니다!");
    //      }
    //    }
    //
    //    if (boardDao.delete(boardNo) == 1) {
    //      out.writeUTF("삭제하였습니다.");
    //    } else {
    //      out.writeUTF("해당 번호의 게시글이 없습니다!");
    //    }
  }

  public void update(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 상세 정보</h1>");

    int boardNo = Integer.parseInt(paramMap.get("no"));
    Board board = boardDao.findByNo(boardNo);

    if (board == null) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");

    } else {
      out.println("<form action='update'>");
      out.println("<table border='1'>");
      out.println("  <tr>");
      out.printf("    <th>번호</th><td><input name='no' type='number' value='%d' readonly></td>", board.no);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>제목</th><td><input name='title' type='text' value='%s' size='60'></td>", board.title);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>내용</th><td><textarea name='content' rows='10' cols='60'>%s</textarea></td>", board.content);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>조회수</th><td>%d</td>", board.viewCount);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>작성자</th><td>%d</td>", board.memberNo);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>등록일</th><td>%s</td>", board.createdDate);
      out.println("  </tr>");
      out.println("</table>");
      out.println("<p>");
      out.println("  <button type='submit'>변경</button>");
      out.println("  <a href='delete?no=%d'>삭제</a>");
      out.println("</p>");
      out.println("</form>");
    }

    out.println("</body>");
    out.println("</html>");


    //    Prompt prompt = new Prompt(in, out);
    //
    //    int boardNo = 0;
    //    while (true) {
    //      try {
    //        boardNo = prompt.inputInt("변경할 게시글 번호? ");
    //        break;
    //      } catch (Throwable ex) {
    //        out.writeUTF("입력 값이 옳지 않습니다!");
    //      }
    //    }
    //
    //    Board board = boardDao.findByNo(boardNo);
    //    if (board == null) {
    //      out.writeUTF("해당 번호의 게시글이 없습니다!");
    //      return;
    //    }
    //
    //    board.title = prompt.inputString("제목?(" + board.title + ") ");
    //    board.content = prompt.inputString(String.format("내용?(%s) ", board.content));
    //
    //    String input = prompt.inputString("변경하시겠습니까?(y/n) ");
    //
    //    if (input.equals("y")) {
    //      if (boardDao.update(board) == 1) {
    //        out.writeUTF("변경했습니다.");
    //      } else {
    //        out.writeUTF("변경 실패입니다!");
    //      }
    //
    //    } else {
    //      out.writeUTF("변경 취소했습니다.");
    //    }
  }
}




