/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

import java.util.Stack;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.util.Prompt;

public class App {

  public static Stack breadcrumbMenu = new Stack();

  public static void main(String[] args) {
    welcome();

    // 인스턴스를 생성할 때 생성자가 원하는 값을 반드시 줘야 한다.
    // 주지 않으면 컴파일 오류이다!
    //
    BoardHandler boardHandler = new BoardHandler();
    BoardHandler readingHandler = new BoardHandler();
    BoardHandler visitHandler = new BoardHandler();
    BoardHandler noticeHandler = new BoardHandler();
    BoardHandler diaryHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();

    breadcrumbMenu.push("메인");

    String[] menus = {"게시판", "독서록", "방명록", "공지사항", "일기장", "회원"};

    loop: while (true) {

      System.out.printf("%s:\n", breadcrumbMenu);
      // 메인 메뉴 출력
      printMenus(menus);

      System.out.println();

      try {
        int mainMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..6](0: 종료) ");

        if (mainMenuNo < 0 || mainMenuNo > menus.length) {
          System.out.println("메뉴 번호가 옳지 않습니다!");
          continue;
        } else if (mainMenuNo == 0) {
          break loop;
        }

        breadcrumbMenu.push(menus[mainMenuNo - 1]);

        switch (mainMenuNo) {
          case 1: // 게시판
            boardHandler.execute();
            break;
          case 2: // 독서록
            readingHandler.execute();
            break;
          case 3: // 방명록
            visitHandler.execute();
            break;
          case 4: // 공지사항
            noticeHandler.execute();
            break;
          case 5: // 일기장
            diaryHandler.execute();
            break;
          case 6: // 회원
            memberHandler.execute();
            break;
        } // switch

        breadcrumbMenu.pop();

      } catch (Exception ex) {
        System.out.println("입력 값이 옳지 않습니다.");
      }


    } // while

    System.out.println("안녕히 가세요!");
    Prompt.close();
  } // main

  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }

  static void printMenus(String[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("   %d: %s\n", i + 1, menus[i]);
    }
  }
}







