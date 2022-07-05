package io.anthonygraca.princeton.chapter4.WordNet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;

public class SAPTest {
  static Digraph g = null;
  @BeforeClass
  public static void beforeClass() {
    In in = new In("src/test/java/io/anthonygraca/princeton/chapter4/WordNet/digraph1.txt");
    g = new Digraph(in);
  }

  @Test(expected=IllegalArgumentException.class)
  public void NullGraphInConstructor() {
    SAP sap = new SAP(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void NegativeVertexForLength() {
    SAP sap = new SAP(g);
    sap.length(-1,-1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void OutsideRangeVertexForLength() {
    SAP sap = new SAP(g);
    sap.length(82192,82192);
  }

  @Test(expected=IllegalArgumentException.class)
  public void NegativeVertexForAncestor() {
    SAP sap = new SAP(g);
    sap.ancestor(-1,-1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void OutsideRangeVertexForAncestor() {
    SAP sap = new SAP(g);
    sap.ancestor(82192,82192);
  }

  @Test(expected=IllegalArgumentException.class)
  public void NullIterableInLength() {
    SAP sap = new SAP(g);
    sap.length(null,null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void NullIterableInAncestor() {
    SAP sap = new SAP(g);
    sap.ancestor(null,null);
  }

  @Test
  public void ExampleOne() {
    SAP sap = new SAP(g);
    int v = 3;
    int w = 11;
    assertEquals(4, sap.length(v, w));
    assertEquals(1, sap.ancestor(v, w));
  }
  @Test
  public void ExampleTwo() {
    SAP sap = new SAP(g);
    int v = 9;
    int w = 12;
    assertEquals(3, sap.length(v, w));
    assertEquals(5, sap.ancestor(v, w));
  }

  @Test
  public void ExampleThree() {
    SAP sap = new SAP(g);
    int v = 7;
    int w = 2;
    assertEquals(4, sap.length(v, w));
    assertEquals(0, sap.ancestor(v, w));
  }

  @Test
  public void ExampleFour() {
    SAP sap = new SAP(g);
    int v = 1;
    int w = 6;
    assertEquals(-1, sap.length(v, w));
    assertEquals(-1, sap.ancestor(v, w));
  }
}
