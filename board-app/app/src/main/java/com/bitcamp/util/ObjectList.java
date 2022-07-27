package com.bitcamp.util;

public class ObjectList {
  private static final int DEFAULT_CAPACITY = 10;

  private int size; 
  private Object[] elementData;

  public void ObjectList() {
    elementData = new Object[size];
  }

  public void ObjectList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  public void add(Object e) {
    if (size == elementData.length) {
      grow();
    }

    elementData[size++] = e;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementData[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    return elementData[index];
  }

  public int size() {
    return size;
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      return false;
    }
    for (int i = index + 1; i < size; i++) {
      elementData[i - 1] = elementData[i];
    }
    elementData[--size] = null;
    return true;
  }

  private void grow() {
    int newCapacity = elementData.length + (elementData.length >> 1);
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
  }
}
