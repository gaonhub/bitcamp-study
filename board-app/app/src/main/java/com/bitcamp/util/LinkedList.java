package com.bitcamp.util;

/**
 * Node를 이용해 값의 목록을 관리하는 일을 한다.
 * 
 * @author bitcamp
 *
 */
public class LinkedList {

  private Node head; // 첫 노드의 주소를 저장
  private Node tail; // 마지막 노드의 주소를 저장
  private int size; // 저장된 데이터의 개수

  /**
   * 파라미터로 주어진 값을 노드에 담아 리스트 끝에 연결한다.
   * @param value
   */
  public void add(Object value) {
    // Node 생성 후 값을 저장한다
    Node node = new Node(value);
    size++; // 목록의 크기를 한 개 증가시킨다.

    // 리스트의 끝에 노드를 붙인다.
    // 만약, 리스트에 노드가 없다면
    if (tail == null) {
      head = tail = node; // 첫 노드를 등록한다.
      return;
    }

    tail.next = node; // 리스트 끝에 새 노드를 연결한다.
    node.prev = tail; // 새 노드가 현재의 끝 노드를 가리키게 한다.

    tail = node; // 새 노드가 끝 노드가 되게 설정한다.
  }

  public Object get(int index) {

    // 인덱스의 유효 여부 검사
    if (index < 0 || index >= size) {
      throw new ListException("인덱스의 범위를 초과했습니다!");
    }

    // 인덱스에 해당하는 노드를 찾을 때 head 부터 시작한다. 
    Node cursor = head;

    // 지정된 인덱스의 노드 주소를 알아낸다.
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    // cursor가 가리키는 노드의 값을 꺼내 리턴한다.
    return cursor.value;
  }

  public void remove(int index) {

    // 인덱스의 유효 여부 검사
    if (index < 0 || index >= size) {
      throw new ListException("인덱스의 범위를 초과했습니다!");
    }

    // 목록 크기를 한 개 줄인다.
    size --;

    // 삭제할 노드를 찾기 위해 시작 노드를 head로 설정한다.
    Node cursor = head;

    // 지정된 인덱스의 노드 주소를 알아낸다.
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    // 찾은 노드의 앞, 뒤 노드를 바로 연결한다.
    cursor.prev.next = cursor.next; // 현재 노드의 다음 노드 주소를 이전 노드의 next 저장
    cursor.next.prev = cursor.prev; // 현재 노드의 이전 노드 주소를 다음 노두의 prev 저장

    // 삭제할 노드를 초기화시킨다.
    // => garbage 객체가 다른 garbage 객체를 참조하지 않게 한다.
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
  }

  public int size() {
    return size;
  }


}