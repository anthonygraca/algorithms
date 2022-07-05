package io.anthonygraca.princeton.chapter4.WordNet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeSet;
import java.util.Iterator;

public class WordNetTest {
  static WordNet net = null;
  @BeforeClass
  public static void beforeClass() {
    net = new WordNet(
        "src/test/java/io/anthonygraca/princeton/chapter4/WordNet/synsets.txt", 
        "src/test/java/io/anthonygraca/princeton/chapter4/WordNet/hypernyms.txt");
  }
  @Test(expected=IllegalArgumentException.class)
  public void CatchDoubleNullInputInConstructor() {
    WordNet w = new WordNet(null, null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void CatchNullSysnetInConstructor() {
    WordNet w = new WordNet(null, "");
  }

  @Test(expected=IllegalArgumentException.class)
  public void CatchNullHypernymsInConstructor() {
    WordNet w = new WordNet("", null);
  }

  @Test
  public void VerifyExampleSysnetEntry() {
    String entry = "36,AND_circuit AND_gate,a circuit in a computer that " + 
                   "fires only when all of its inputs fire ";
    WordNet net = new WordNet();
    net.getSysnetFromEntry(entry);
    assertTrue(net.isNoun("AND_circuit"));
    assertTrue(net.isNoun("AND_gate"));
    assertFalse(net.isNoun("OR_gate"));
  }

  @Test
  public void VerifyNounsIterator() {
    String entry = "36,AND_circuit AND_gate,a circuit in a computer that " + 
                   "fires only when all of its inputs fire ";
    TreeSet<String> expected = new TreeSet<String>();
    expected.add("AND_circuit");
    expected.add("AND_gate");
    WordNet net = new WordNet();
    net.getSysnetFromEntry(entry);
    Iterator<String> iter = net.nouns().iterator();
    assertTrue(expected.contains(iter.next()));
    assertTrue(expected.contains(iter.next()));
  }

  @Test
  public void VerifyExampleHypernymEntry() {
    String entry = "34,47569,48084";
    WordNet net = new WordNet();
    String[] output = net.getHypernymsFromEntry(entry);
    assertEquals(output[0], "34");
    assertEquals(output[1], "47569");
    assertEquals(output[2], "48084");
  }

  @Test(expected=IllegalArgumentException.class)
  public void CatchDistanceArgumentIsNotANoun() {
    net.distance("boogly", "woogly");
  }

  @Test(expected=IllegalArgumentException.class)
  public void CatchSapArgumentIsNotANoun() {
    net.sap("boogly", "woogly");
  }

  @Test
  public void ReadFile() {
    assertTrue(net.isNoun("AND_circuit"));
    assertTrue(net.isNoun("AND_gate"));
    assertFalse(net.isNoun("random_word"));
  }

  @Test
  public void CheckValidRootedDag() {
    assertEquals(38003, net.checkValidRootedDag());
  }

  @Test
  public void ValidateSAPDistance() {
    String nounA = "dada";
    String nounB = "siamese_connection";
    assertEquals(13, net.distance(nounA, nounB));
  }

  /*
    problem caused by not calling iterator version.
    find way to speed up iterator SAP
   */
  //@Test
  public void ValidateSAPDistanceExampleTwo() {
    String nounA = "Savoyard";
    String nounB = "liquidator";
    assertEquals(5, net.distance(nounA, nounB));
  }

}
