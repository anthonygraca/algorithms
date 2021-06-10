package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BagTest {
  /*
   * These test the functionality of the constructor
   */
  @Test
  public void defaultConstructor(){
    ArrayBag bag = new ArrayBag();
    assertTrue(bag.size() == 0);
  }

  /*
   * These test the functionality of size
   */
  @Test
  public void sizeIncrements(){
    ArrayBag<String> bag = new ArrayBag<>();
    bag.add("some string");
    assertTrue(bag.size() == 1);
  }

  @Test
  public void sizeIncrementsThroughResizing(){
    ArrayBag<String> bag = new ArrayBag<>();
    for (int i = 0; i < 26; i++){
      bag.add("String " + i);
    }
    assertTrue(bag.size() == 26);
  }

  /*
   * These test the functionality of the add method
   */
  @Test
  public void addedItemIsInBag(){
    ArrayBag<String> bag = new ArrayBag<>();
    bag.add("A string");
    assertTrue(bag.getItem().equals("A string"));
  }

  @Test
  public void bagProperlyResizesAndAdds(){
    ArrayBag<String> bag = new ArrayBag<>();
    for (int i = 0; i < 25; i++){
      bag.add("String " + i);
    }
    bag.add("New string");
    assertTrue(bag.getItem().equals("New string"));
  }

  /*
   * These test the iterator
   */
  @Test
  public void iteratorWorksWithoutResize(){
    ArrayBag<String> bag = new ArrayBag<>();
    for (int i = 0; i < 25; i++){
      bag.add("A string");
    }

    for (String s : bag){
      assertTrue(s.equals("A string"));
    }
  }

  @Test
  public void iteratorWorksWithResizing(){
    ArrayBag<String> bag = new ArrayBag<>();
    for (int i = 0; i < 51; i++){
      bag.add("A string");
    }

    for (String s : bag){
      assertTrue(s.equals("A string"));
    }
  }
}
