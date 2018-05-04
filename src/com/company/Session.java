package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Session {
  private static Session ourInstance = new Session();

  public static Session getInstance() {
    return ourInstance;
  }
  private ArrayList<Player> users = new ArrayList();
  private ArrayList gameTypes = new ArrayList();
  private ArrayList games = new ArrayList();

  public void getUsers() {
    for (Object user : users) {
      System.out.println(user.toString());
    }
  }

  public Player getUser(int index) {
    return users.get(index);
  }

  public void addUser(Player user) {
    this.users.add(user);
  }

  public void playMatch(CreateGame game, Player player1, String player1move, Player player2, String player2move) {
    System.out.printf("%s %s %s %s %s %s %s%s ", player1.getName(), "plays", player1move, "and", player2.getName(), "plays", player2move, ":");
    if (game.playGame(player1move, player2move)) {
      System.out.println(player1.getName() + " WINS!");
      postMatch(player1, player2);
    } else {
      System.out.println(player2.getName() + " WINS!");
      postMatch(player2, player1);
    }
  }

  public void postMatch(Player winner, Player loser) {
    Date now = new Date();
//    System.out.println(winner.toString());
    winner.updateGames(loser.getName(),true, now);
    loser.updateGames(winner.getName(), false, now);
  }

  private Session() {

  }
}
