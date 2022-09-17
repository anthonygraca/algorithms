package io.anthonygraca.princeton.chapter6.BaseballElimination;

import java.io.File;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.In;

public class BaseballEliminationTest {
  final String prefix =
    "src/test/java/io/anthonygraca/princeton/chapter6/BaseballElimination/";

  @Test(expected=IllegalArgumentException.class)
  public void CatchNullInputInConstructor() {
    BaseballElimination be = new BaseballElimination(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void CatchInvalidFileInputInConstructor() {
    BaseballElimination be = new BaseballElimination("invalid-filename.txt");
  }

  @Test
  public void NumberOfTeamsInTeams4Input() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    assertEquals(be.numberOfTeams(), 4);
  }

  @Test
  public void NumberOfTeamsInTeams5Input() {
    BaseballElimination be = new BaseballElimination(prefix + "teams5.txt");
    assertEquals(be.numberOfTeams(), 5);
  }

  //@Test
  public void ValidateIterable() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    Iterable<String> iterable = be.teams();
    Iterator<String> iterator = iterable.iterator();
    assertTrue(iterator.hasNext());
    
    //assertEquals(be.numberOfTeams(), 4);
  }

  @Test
  public void ValidateAlgs4Scanner() {
    File file = new File(prefix + "teams4.txt");
    In in = new In(file);
    int team_count = in.readInt();
    assertEquals(team_count, 4);
  }

  @Test
  public void ValidateAlgs4ScannerTeamNames() {
    File file = new File(prefix + "teams4.txt");
    In in = new In(file);
    int team_count = in.readInt();
    in.readLine();
    String team_name = in.readLine();
    assertEquals(team_name.substring(0, team_name.indexOf(' ')), "Atlanta");
  }

  
}
