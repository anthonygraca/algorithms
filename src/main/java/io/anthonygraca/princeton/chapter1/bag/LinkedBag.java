package io.anthonygraca.princeton.chapter1;

public class LinkedBag<T> implements Bag<T>{
  private Node head;
  private Node tail;
  private int size;
  private final int DEFAULT_CAPACITY = 25;

  /**
   * Default constructor
   */
  public LinkedBag(){

  }

  /**
   * Adds an item to the bag
   * @param item  the item being added
   */
  public void add(T item){

  }

  /**
   * Checks if the bag is empty
   * @return  true if empty, false if not
   */
  public boolean isEmpty(){
    return true;
  }

  /**
   * Finds the number of items currently in the bag
   * @return  the number of items currently in the bag
   */
  public int size(){
    return 0;
  }

  /*
   * the node, as a nested class
   */
  private class Node{
    public T data;
    public Node next;

    public Node(){
      this(null, null);
    }

    public Node(T item){
      this(item, null);
    }

    public Node(T item, Node nextNode){
      data = item;
      next = nextNode;
    }
  }

}
