package com.company;

import java.util.Date;
import java.util.ArrayList;

public class Player {
  private int id;
  private String name;
  private int wins = 0;
  private int losses = 0;
  private int ties = 0;
  private ArrayList<String> games = new ArrayList();

  public Player(String name) {
    id = Session.getInstance().newPlayerId();
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void updateGames(String name, String status, Date date) {
    wins += status.equals("win") ? 1 : 0;
    losses += status.equals("lose") ? 1 : 0;
    ties += status.equals("tie") ? 1 : 0;
    // String game = this.name + (status ? " beat " : " lost to ") + name + " on " + date + ".";
    // https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
    String game = String.format("%s %s %s %s %tB %te, %tY%s", this.name, status.equals("win") ? "beat" : status.equals("lose") ? "lost to" : "tied", name, "on", date, date, date, ".");
    games.add(game);
  }

  public void displayGames() {
    System.out.println("--------------------------------");
    System.out.printf("%s%s\n", name,"'s Win/Loss/Tie Record:");
    System.out.println("--------------------------------");
    for (String game : games) {
      System.out.println(game);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format(
     "%s %s %d %s %d %s %d %s %d %s",
     name,
     "has",
     wins,
     (wins != 1 ? "wins and" : "win and"),
     losses,
     (losses !=1 ? "losses and" : "loss and"),
     ties,
     (ties !=1 ? "ties in" : "tie in"),
     wins + losses + ties,
     wins + losses + ties == 1 ? "game!" : "games!"
    );
    //return name + " has " + wins + " wins and " + losses + " losses in " + (wins + losses) + " games!";
  }

}
