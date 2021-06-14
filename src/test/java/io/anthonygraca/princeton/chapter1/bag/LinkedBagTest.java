package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedBagTest {
  /*
   * These test the functionality of the constructor
   */
  @Test
  public void defaultConstructor(){
    LinkedBag bag = new LinkedBag();
    assertTrue(bag.size() == 0);
  }

  /*
   * These test the functionality of size
   */
  @Test
  public void sizeIncrements(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.add("some string");
    assertTrue(bag.size() == 1);
  }

  @Test
  public void sizeIncrementsThroughResizing(){
    LinkedBag<String> bag = new LinkedBag<>();
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
    LinkedBag<String> bag = new LinkedBag<>();
    bag.add("A string");
    assertTrue(bag.getItem().equals("A string"));
  }

  @Test
  public void bagProperlyResizesAndAdds(){
    LinkedBag<String> bag = new LinkedBag<>();
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
    LinkedBag<String> bag = new LinkedBag<>();
    for (int i = 0; i < 25; i++){
      bag.add("A string");
    }

    for (String s : bag){
      assertTrue(s.equals("A string"));
    }
  }

  @Test
  public void iteratorWorksWithResizing(){
    LinkedBag<String> bag = new LinkedBag<>();
    for (int i = 0; i < 51; i++){
      bag.add("A string");
    }

    for (String s : bag){
      assertTrue(s.equals("A string"));
    }
  }

  /*
   * These test the functionality of remove
   */
  @Test(expected=IllegalStateException.class)
  public void randomRemoveFailsForEmptyBag(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.remove();
  }

  @Test
  public void randomRemoveSucceedsForOneItemInTheBag(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.add("Test string");
    assertTrue(bag.remove().equals("Test string"));
  }

  @Test
  public void randomRemoveSucceedsForMoreThanOneItemInTheBag(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.add("Test string 1");
    bag.add("Test string 2");
    String removedItem = bag.remove();
    assertTrue(removedItem.equals("Test string 1") || removedItem.equals("Test string 2"));
  }

  @Test(expected=IllegalStateException.class)
  public void specificRemoveFailsForEmptyBag(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.remove("test string");
  }

  @Test(expected=IllegalStateException.class)
  public void specificRemoveFailsForAnItemNotInTheBag(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.add("Test string");
    bag.remove("Best ring");
  }

  @Test
  public void specificRemoveSucceedsForItemInTheBag(){
    LinkedBag<String> bag = new LinkedBag<>();
    bag.add("Test string");
    assertTrue(bag.remove("Test string").equals("Test string"));
  }
}
