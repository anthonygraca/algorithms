package io.anthonygraca.princeton.chapter4.WordNet;

public class Outcast {
  final private WordNet net;
  public Outcast(WordNet wordnet) {
    net = wordnet;
  }
  public String outcast(String[] nouns) {
    int[] distances = new int[nouns.length];
    for (int i = 0; i < nouns.length; i++) {
      distances[i] = 0;
    }
    for (int i = 0; i < nouns.length; i++) {
      int accumulate = 0;

      for (int j = 0; j < nouns.length; j++) {
	accumulate += net.distance(nouns[i], nouns[j]);
      }
      distances[i] = accumulate;
    }
    int max = -1;
    int outcast = -1;
    for (int i = 0; i < nouns.length; i++) {
      if (distances[i] > max) {
	max = distances[i];
	outcast = i;
      }
    }
    return nouns[outcast];
  }
}
