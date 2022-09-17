package io.anthonygraca.princeton.chapter6.BaseballElimination;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.algs4.In;

public class BaseballElimination {
  private final int team_count_;
  private final ArrayList<String> teams_;
  public BaseballElimination(String filename) {
    if (filename == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
    try {
      File file = new File(filename);
      In in = new In(file);
      if (in.hasNextLine()) {
        team_count_ = in.readInt();
      }
      else {
        team_count_ = -1;
      }
      teams_ = new ArrayList<String>();
      if (in.hasNextLine()) {
        String line = in.readLine();
        if (line.indexOf(' ') != -1) {
          line.substring(0, line.indexOf(' '));
        }
        //Teams_.add(line.substring(0, "atlanta ".indexOf(' ')));
      }
      
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  public int numberOfTeams() {
    return team_count_;
  }

  public Iterable<String> teams() {
    return teams_;
  }
  
}
