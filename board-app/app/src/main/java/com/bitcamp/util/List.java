package com.bitcamp.util;

/**
 * 인덱스를 기반으로 목록을 다루는 메서드의 규격을 정한다.
 * @author bitcamp
 *
 */
// List에서 다루는 항목의 타입을 외부에서 받을 수 있도록
// 타입 파라미터를 선언한다.

// 타입 파라미터 이름:
//   - 타입을 받는 파라미터임을 드러내기 위해 일반변수와 달리 대문자로 시작한다.
//   - 변수의 이름을 간결하게 유지하기 위해 한 개의 알파벳을 사용한다.
//   - 예) 
//         Element ==> E

public interface List<E> {
  // 메서드 형식
  // - 추상 메서드 형태
  // - 무조건 public 으로 공개

  // E 가 가리키는 타입은 List를 사용하는 시점에 결정된다.
  // 
  void add(E value); 
  E get(int index); 
  E remove(int index);
  Object[] toArray();
  E[] toArray(E[] arr);
  int size();

}
