package com.bitcamp.board.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.board.domain.Member;

public class MemberDaoProxyTest {

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("127.0.0.2", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      MemberDaoProxy memberDao = new MemberDaoProxy("member", in, out);

      // 테스트 1) 목록 가져오기
      Member[] members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("----------------------------------------------------------");

      // 테스트 2) 상세 데이터 가져오기
      Member member = memberDao.findByEmail("hong@test.com");
      System.out.println(member);
      System.out.println("----------------------------------------------------------");

      // 테스트 3) 데이터 등록하기
      member = new Member();
      member.name = "xxxx";
      member.email = "xxxxxxxxxxx";
      member.createdDate = System.currentTimeMillis();
      member.password = "1111";


      System.out.println(memberDao.insert(member));
      System.out.println("----------------------------------------------------------");

      // 테스트 1) 목록 가져오기
      members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("----------------------------------------------------------");

      // 테스트 4) 데이터 변경하기
      member = memberDao.findByEmail("aa@test.com");
      member.name = "okokok";
      member.email = "asdf@test.com";
      System.out.println(memberDao.update(member));
      System.out.println("----------------------------------------------------------");

      // 데이터 변경 확인
      member = memberDao.findByEmail("bb@test.com");
      System.out.println(member);
      System.out.println("----------------------------------------------------------");

      // 테스트 5) 데이터 삭제하기
      System.out.println(memberDao.delete("cc@test.com"));
      System.out.println("----------------------------------------------------------");

      // 데이터 삭제 확인
      members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("----------------------------------------------------------");

      out.writeUTF("exit");


    }
  }

}
