package com.company;

import java.util.Date;
import java.util.ArrayList;

public class Player {
  private int id;
  private String name;
  private int wins = 0;
  private int losses = 0;
  private ArrayList<String> games = new ArrayList();

  public Player(String name) {
    this.id = 1; //+ number of other accounts
    this.name = name;
  }

  public void updateGames(String name, boolean status, Date date) {
    wins += status ? 1 : 0;
    losses += status ? 0 : 1;
    // String game = this.name + (status ? " beat " : " lost to ") + name + " on " + date + ".";
    // https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
    String game = String.format("%s%s%s%s%tB %te, %tY%s", this.name, status ? " beat " : " lost to ", name, " on ", date, date, date, ".");
    games.add(game);
  }

  public void displayGames() {
    System.out.println("--------------------------------");
    System.out.printf("%-13s%s\n", name,"'s Win/Loss Record:");
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
     "%s%s%d%s%d%s%d%s",
     name,
     " has ",
     wins,
     (wins != 1 ? " wins and " : " win and "),
     losses,
     (losses !=1 ? " losses in " : " loss in "),
     wins + losses,
     wins + losses == 1 ? " game!" : " games!"
    );
    //return name + " has " + wins + " wins and " + losses + " losses in " + (wins + losses) + " games!";
  }

}
