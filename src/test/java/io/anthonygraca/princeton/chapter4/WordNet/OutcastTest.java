package io.anthonygraca.princeton.chapter4.WordNet;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class OutcastTest {
  static WordNet net = null;
  @BeforeClass
  public static void beforeClass() {
    net = new WordNet(
        "src/test/java/io/anthonygraca/princeton/chapter4/WordNet/synsets.txt", 
        "src/test/java/io/anthonygraca/princeton/chapter4/WordNet/hypernyms.txt");
  }
  

}
