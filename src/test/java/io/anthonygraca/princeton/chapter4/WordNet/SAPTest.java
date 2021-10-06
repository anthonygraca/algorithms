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
}
