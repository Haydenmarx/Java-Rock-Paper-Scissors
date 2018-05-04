package com.company;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Session gameSession = Session.getInstance();
    Player player = new Player("Hayden");
    gameSession.addUser(player);
    player = new Player("David");
    gameSession.addUser(player);
//    gameSession.getUsers();
    ArrayList<String> newType = new ArrayList() {{
      add("Rock");
      add("Bird");
      add("Water");
    }};
    CreateGame test = new CreateGame(newType);
    System.out.println(test.toString());
    gameSession.playMatch(test, gameSession.getUser(0), "Rock", gameSession.getUser(1), "Bird");
    gameSession.getUsers();


//    System.out.println(gameSession.getUser(0).toString());
//    System.out.println(gameSession.getUser(1).toString());



//    ArrayList<String> newType = new ArrayList() {{
//      add("Spock");
//      add("Scissors");
//      add("Paper");
//      add("Rock");
//      add("Lizard");
//    }};
//    CreateGame test = new CreateGame(newType);
//    System.out.println(test.toString());
//    System.out.println(test.playGame("Spock", "Scissors"));
//    System.out.println(test.playGame("Scissors", "Spock"));

  }
}
