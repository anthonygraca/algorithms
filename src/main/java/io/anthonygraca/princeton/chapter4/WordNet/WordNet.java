package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Topological;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.HashMap;

public class WordNet {

  private Digraph graph = null;
  private HashMap<String, ArrayList<Integer>> map =
    new HashMap<String, ArrayList<Integer>>();
  private ArrayList<ArrayList<String>> synset =
    new ArrayList<ArrayList<String>>();
  private int m_count = 0;
  private SAP sap = null;

  protected WordNet() {
    graph = new Digraph(48085);
  }

  public WordNet(String sysnets, String hypernyms) {
    if (sysnets == null || hypernyms == null) {
      throw new IllegalArgumentException("WordNet cannot have null input");
    }
    readSysnetsFromFile(new File(sysnets));
    graph = new Digraph(m_count);
    readHypernymsFromFile(new File(hypernyms));
    checkValidRootedDag();
    sap = new SAP(graph);
  }

  protected boolean checkValidRootedDag() {
    Topological t = new Topological(graph);
    if (!t.hasOrder()) {
      throw new IllegalArgumentException("No root");
    }
    return true;

  }

  private void readSysnetsFromFile(File file) {
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
	getSysnetFromEntry(sc.nextLine());
	m_count++;
      }
      sc.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("file can't be processed");
    }
  }

  private void readHypernymsFromFile(File file) {
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
	getHypernymsFromEntry(sc.nextLine());
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("file can't be processed");
    }
  }

  protected String[] getSysnetFromEntry(String entry) {
    String[] fields = entry.split(",");
    String[] nouns = fields[1].split(" ");
    ArrayList<String> synonyms = new ArrayList<String>();
    for (int i = 0; i < nouns.length; i++) {
      int id = Integer.parseInt(fields[0]);
      if (map.containsKey(nouns[i])) {
	map.get(nouns[i]).add(id);
      }
      else {
	ArrayList<Integer> ids = new ArrayList<Integer>();
	ids.add(id);
	map.put(nouns[i], ids);
      }
      synonyms.add(nouns[i]);
    }
    synset.add(synonyms);
    return fields;
  }

  protected String[] getHypernymsFromEntry(String entry) {
    String[] fields = entry.split(",");
    for (int i = 1; i < fields.length; i++) {
      graph.addEdge(Integer.parseInt(fields[0]), Integer.parseInt(fields[i]));
    }
    return fields;
  }

  // must be T:O(logn)
  public boolean isNoun(String query) {
    if (query == null) {
      throw new IllegalArgumentException("null");
    }
    return map.containsKey(query);
  }

  public Iterable<String> nouns() {
    return new GeneratedNouns();
  }

  // must be T:O(n)
  public int distance(String noun_a, String noun_b) {
    if (!isNoun(noun_a) || !isNoun(noun_b)) {
      throw new IllegalArgumentException("distance() arguments must be valid nouns");
    }
    return sap.length(map.get(noun_a), map.get(noun_b));
  }

  // must be T:O(n)
  public String sap(String noun_a, String noun_b) {
    if (!isNoun(noun_a) || !isNoun(noun_b)) {
      throw new IllegalArgumentException("distance() arguments must be valid nouns");
    }
    ArrayList<String> list =
      synset.get(sap.ancestor(map.get(noun_a), map.get(noun_b)));
    String nouns = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      nouns = nouns + " " + list.get(i);
    }
    return nouns;
    //   return synset.get(sap.ancestor(map.get(noun_a), map.get(noun_b))).get(0);
  }

  protected Digraph getGraph() {
    return graph;
  }

  private class GeneratedNouns implements Iterable<String> {
    public Iterator<String> iterator() {
      return new GeneratedNounsIterator();
    }

  private class GeneratedNounsIterator implements Iterator<String> {
    Iterator<String> iter = map.keySet().iterator();
    public GeneratedNounsIterator() {
    }
    public boolean hasNext() {
      return iter.hasNext();
    }
    public void remove() {
      throw new UnsupportedOperationException("Remove is unsupported");
    }
    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException("Empty");
      }
      return iter.next();
    }
  }
  }
}
