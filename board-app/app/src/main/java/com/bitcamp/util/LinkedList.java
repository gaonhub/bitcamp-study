package com.bitcamp.util;

public class LinkedList {

  private Node head;
  private Node tail;
  private int size;

  public void append(Object value) {

    Node node = new Node(value);

    size++;

    if (tail == null) {
      head = tail = node;
      return;
    }

    tail.next = node;
    node.prev = tail;

    tail = node;
  }

  public Object retrieve(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("유효한 인덱스가 아닙니다!");
    }

    Node cursor = head;

    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public Object delete(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("유효한 인덱스가 아닙니다!");
    }

    size--;

    Object deleted;

    if (head == tail) {
      deleted = head.value;
      head.value = null;
      head = tail = null;
      return deleted;
    }

    Node cursor = head;

    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    if (cursor.prev != null) {
      cursor.prev.next = cursor.next;
    } else {
      head = cursor.next;
      head.prev = null;
    }

    if (cursor.next != null) {
      cursor.next.prev = cursor.prev;
    } else {
      tail = cursor.prev;
      tail.next = null;
    }

    deleted = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;

    return deleted;


  }




}
