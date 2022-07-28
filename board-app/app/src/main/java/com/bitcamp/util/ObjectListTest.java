package com.bitcamp.util;

public class ObjectListTest {
  public static void main(String[] args) {
    ObjectList list = new ObjectList();

    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add(null); // 목록에 null 넣을 수 있다.
    list.add("안중근");

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2)); 
    System.out.println(list.get(4));

    // 3번 인덱스에 null이 들어 있기 때문에 꺼낸 값도 null 이다.
    System.out.println(list.get(3)); // println()에 전달하는 값이 null이면 "null"이라고 출력한다.

    // 100번 인덱스는 유효한 인덱스가 아니기 때문에 get() 메서드가 null을 리턴한다.
    System.out.println(list.get(100));

    // 생각해 볼 문제!
    // - get()이 null을 리턴한다면,
    //   예외 상황인가? 아니면 그냥 정상적인 상황인가?
    // 결론!
    // - 알 수 없다.
    // - 리턴 값으로는 정상과 예외 사황을 표현할 수 없다.
    // - 리턴 값으로 두 상황을 구분할 수 없다.
    //


  }
}