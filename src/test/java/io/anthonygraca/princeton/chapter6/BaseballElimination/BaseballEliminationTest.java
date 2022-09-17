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

  @Test
  public void ValidateIterableContainsValues() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    Iterable<String> iterable = be.teams();
    Iterator<String> iterator = iterable.iterator();
    assertTrue(iterator.hasNext());
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
  
  @Test
  public void ValidateIterableExactValues() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    Iterable<String> iterable = be.teams();
    Iterator<String> iterator = iterable.iterator();
    assertEquals("Atlanta", iterator.next());
    assertEquals("Philadelphia", iterator.next());
    assertEquals("New_York", iterator.next());
    assertEquals("Montreal", iterator.next());
    assertFalse(iterator.hasNext());
  }

  @Test
  public void GetWinsForAtlanta() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    assertEquals(83, be.wins("Atlanta"));
  }

  @Test
  public void GetOtherWins() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    assertEquals(80, be.wins("Philadelphia"));
    assertEquals(78, be.wins("New_York"));
    assertEquals(77, be.wins("Montreal"));
  }

  @Test
  public void GetLosses() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    assertEquals(71, be.losses("Atlanta"));
    assertEquals(79, be.losses("Philadelphia"));
    assertEquals(78, be.losses("New_York"));
    assertEquals(82, be.losses("Montreal"));
  }
  
  @Test
  public void GetRemainingGames() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    assertEquals(8, be.remaining("Atlanta"));
    assertEquals(3, be.remaining("Philadelphia"));
    assertEquals(6, be.remaining("New_York"));
    assertEquals(3, be.remaining("Montreal"));
  }

  @Test
  public void ValidateStringSplitRegex() {
    String team_data = "Atlanta       83 71  8  0 1 6 1";
    String[] data = team_data.split("\\s+");
    assertEquals("Atlanta", data[0]);
    assertEquals(83, Integer.parseInt(data[1]));
    assertEquals(71, Integer.parseInt(data[2]));
    assertEquals(8, Integer.parseInt(data[3]));
    assertEquals(0, Integer.parseInt(data[4]));
    assertEquals(1, Integer.parseInt(data[5]));
    assertEquals(6, Integer.parseInt(data[6]));
    assertEquals(1, Integer.parseInt(data[7]));
  }
  
  @Test
  public void GetRemainingGamesAgainstSpecificTeam() {
    BaseballElimination be = new BaseballElimination(prefix + "teams4.txt");
    assertEquals(0, be.against("Atlanta", "Atlanta"));
    assertEquals(1, be.against("Atlanta", "Philadelphia"));
    assertEquals(6, be.against("Atlanta", "New_York"));
    assertEquals(1, be.against("Atlanta", "Montreal"));
    assertEquals(1, be.against("Philadelphia", "Atlanta"));
    assertEquals(0, be.against("Philadelphia", "Philadelphia"));
    assertEquals(0, be.against("Philadelphia", "New_York"));
    assertEquals(2, be.against("Philadelphia", "Montreal"));
    assertEquals(6, be.against("New_York", "Atlanta"));
    assertEquals(0, be.against("New_York", "Philadelphia"));
    assertEquals(0, be.against("New_York", "New_York"));
    assertEquals(0, be.against("New_York", "Montreal"));
    assertEquals(1, be.against("Montreal", "Atlanta"));
    assertEquals(2, be.against("Montreal", "Philadelphia"));
    assertEquals(0, be.against("Montreal", "New_York"));
    assertEquals(0, be.against("Montreal", "Montreal"));
  }  
}
