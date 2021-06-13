package io.anthonygraca.princeton.chapter1.stack;

public class LinkedListStack<Item> {

  Node first = null;
  int m_size = 0;

  private class Node {
    Item item;
    Node next = null;
  }

  public boolean isEmpty() {
    return m_size == 0;
  }

  public void push(Item item) {
    Node new_node = new Node();
    new_node.item = item;
    new_node.next = first;
    first = new_node;
    m_size++;
  }

  public int getSize() {
    return m_size;
  }

  public Item pop() {
    Node popped_node = first;
    first = first.next;
    m_size--;
    return popped_node.item;
  }
}
