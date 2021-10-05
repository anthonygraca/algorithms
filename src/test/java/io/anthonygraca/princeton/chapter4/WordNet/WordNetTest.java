package io.anthonygraca.princeton.chapter4.WordNet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.TreeSet;
import java.util.Iterator;

public class WordNetTest {
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
    String entry = "36,AND_circuit AND_gate,a circuit in a computer that " + 
                   "fires only when all of its inputs fire ";
    TreeSet<String> expected = new TreeSet<String>();
    expected.add("AND_circuit");
    expected.add("AND_gate");
    WordNet net = new WordNet();
    net.getSysnetFromEntry(entry);
    net.distance("boogly", "woogly");
  }

  @Test(expected=IllegalArgumentException.class)
  public void CatchSapArgumentIsNotANoun() {
    String entry = "36,AND_circuit AND_gate,a circuit in a computer that " + 
                   "fires only when all of its inputs fire ";
    TreeSet<String> expected = new TreeSet<String>();
    expected.add("AND_circuit");
    expected.add("AND_gate");
    WordNet net = new WordNet();
    net.getSysnetFromEntry(entry);
    net.sap("boogly", "woogly");
  }

  @Test
  public void ReadFile() {
    WordNet net = new WordNet("synsets.txt", "hypernyms.txt");
    assertTrue(net.isNoun("AND_circuit"));
    assertTrue(net.isNoun("AND_gate"));
    Iterator<String> iter = net.nouns().iterator();
    assertFalse(net.isNoun("random_word"));
  }
}
