package com.bitcamp.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import com.bitcamp.util.BreadCrumb;

// Handler 규격에 맞춰 서브 클래스에게 물려줄 공통 필드나 메서드를 구현한다.
// 
public abstract class AbstractHandler implements Handler {

  // 핸들러가 사용할 메뉴 목록을 담을 배열을 준비한다.
  // => 메뉴 목록은 생성자를 통해 초기화시킨다.
  //
  private String[] menus;

  // 반드시 메뉴 목록을 초기화시키도록 강제하기 위해 
  // 기본 생성자 대신 메뉴 목록을 배열로 받는 생성자를 준비한다.
  public AbstractHandler(String[] menus) {
    this.menus = menus;
  }

  // 다음 메서드는 execute()에서 메뉴를 출력할 때 사용된다.
  // 다만 서브 클래스서 출력 형식을 바꾸기 위해 오버라이딩 할 수 있도록 
  // 접근 범위를 protected로 설정한다.
  protected void printMenus(PrintWriter out) {
    for (int i = 0; i < menus.length; i++) {
      out.printf("  %d: %s\n", i + 1, menus[i]);
    }

    out.printf("메뉴를 선택하세요[1..%d](0: 이전) ", menus.length);
  }

  protected static void printHeadline(PrintWriter out) {
    out.println("=========================================");
  }

  protected static void printBlankLine(PrintWriter out) {
    out.println(); // 메뉴를 처리한 후 빈 줄 출력
  }

  @Override
  public void execute(DataInputStream in, DataOutputStream out) throws Exception {

    // 현재 스레드를 위해 보관된 Breadcrumb 객체를 꺼낸다.
    BreadCrumb breadcrumb = BreadCrumb.getBreadCrumbOfCurrentThread();

    // 핸들러의 메뉴를 클아이언트에게 보낸다.
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {

      tempOut.println(breadcrumb.toString());
      printMenus(tempOut);
      out.writeUTF(strOut.toString());
    }

    while (true) {

      // 클라이언트가 보낸 요청을 읽는다.
      String request = in.readUTF();
      if (request.equals("0")) {
        break;
      }

      try (StringWriter strOut = new StringWriter();
          PrintWriter tempOut = new PrintWriter(strOut)) {

        tempOut.println("해당 메뉴를 준비 중입니다.");

        printBlankLine(tempOut);
        tempOut.println(breadcrumb.toString());
        printMenus(tempOut);
        out.writeUTF(strOut.toString());
      }

      /*
      try {


        if (menuNo < 0 || menuNo > menus.length) {
          System.out.println("메뉴 번호가 옳지 않습니다!");
          continue; // while 문의 조건 검사로 보낸다.

        } else if (menuNo == 0) {
          return; // 메인 메뉴로 돌아간다.
        }

        // 메뉴에 진입할 때 breadcrumb 메뉴바에 그 메뉴를 등록한다.
        ServerApp.breadcrumbMenu.push(menus[menuNo - 1]);

        printHeadline();

        // 서브 메뉴의 제목을 출력한다.
        printTitle();

        // 사용자가 입력한 메뉴 번호에 대해 작업을 수행한다.
        service(menuNo);

        printBlankLine();

        ServerApp.breadcrumbMenu.pop();

      } catch (Exception ex) {
        System.out.printf("예외 발생: %s\n", ex.getMessage());
        ex.printStackTrace();
      }
       */
    } // while

  }

  // 서브 클래스가 반드시 만들어야 할 메서드
  // => 메뉴 번호를 받으면 그 메뉴에 해당하는 작업을 수행한다.
  // => 서브 클래스에게 구현을 강제하기 위해 추상 메서드로 선언한다.
  public abstract void service(int menuNo);
}






