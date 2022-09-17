package io.anthonygraca.princeton.chapter6.BaseballElimination;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import edu.princeton.cs.algs4.In;

public class BaseballElimination {
  private ArrayList<String> teams_ = new ArrayList<String>();
  private HashMap<String, Integer> team_number_ = new HashMap<String, Integer>();
  private HashMap<String, ArrayList<Integer>> team_data_ =
      new HashMap<String, ArrayList<Integer>>();
  public BaseballElimination(String filename) {
    if (filename == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
    try {
      File file = new File(filename);
      readAndStoreDataFromFile(file);
    } catch (IllegalArgumentException e) {
      throw e;
    }
  }

  private void readAndStoreDataFromFile(File file) {
    In in = new In(file);
    readNumberOfTeams(in);
    readAndStoreTeamData(in);
  }
  
  private int readNumberOfTeams(In in) {
    int team_count = 0;
    if (in.hasNextLine()) {
      team_count = in.readInt();
      in.readLine(); // consume newline;
    }
    return team_count;
  }
  
  private void readAndStoreTeamData(In in) {
    int team_number = 0;
    while (in.hasNextLine()) {
      String line = in.readLine();
      String[] data = line.split("\\s+");
      String team_name = data[0];
      team_number_.put(team_name, team_number);
      teams_.add(team_name);
      ArrayList<Integer> team_data = new ArrayList<Integer>();
      for (int i = 1; i < data.length; i++) {
        team_data.add(Integer.parseInt(data[i]));
      }
      team_data_.put(team_name, team_data);
      team_number++;
    }
  }

  public int numberOfTeams() {
    return team_number_.size();
  }

  public Iterable<String> teams() {
    return teams_;
  }

  public int wins(String team) {
    final int offset = 0;
    return team_data_.get(team).get(offset);
  }

  public int losses(String team) {
    final int offset = 1;
    return team_data_.get(team).get(offset);
  }

  public int remaining(String team) {
    final int offset = 2;
    return team_data_.get(team).get(offset);
  }

  public int against(String a, String b) {
    final int offset = 3;
    final int team_number = team_number_.get(b) + offset;
    return team_data_.get(a).get(team_number);
  }
  
}
