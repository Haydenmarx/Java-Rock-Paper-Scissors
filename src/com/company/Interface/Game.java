package com.company.Interface;

import com.company.Generators.CreateGame;
import com.company.Generators.CreatePlayer;
import com.company.Session;

public class Game implements Sections {
  private static Game ourInstance = new Game();

  public static Game getInstance() {
    return ourInstance;
  }

  private Game() {
  }

  private CreatePlayer playerOne;
  private String playerOneMove = "";
  private CreatePlayer playerTwo;
  private String playerTwoMove = "";
  private CreateGame currentGame;
  private int counter = 1;
  private Session gameSession = Session.getInstance();


  public void display(String currentPage) {
    if (currentPage.equals("home")) {
      System.out.println("Select Player 1");
      System.out.println("PLAYER LIST:");
      System.out.println("------------");
      gameSession.getUserNames();
      System.out.println();
      System.out.println("Type home to return to the main menu. Or Select a user. Selecting Computer will mean random play.");
    } else if (currentPage.equals("player2")) {
      System.out.println("Select Player 2");
      System.out.println("PLAYER LIST:");
      System.out.println("------------");
      gameSession.getUserNames();
      System.out.println();
      System.out.println("Select a user. Selecting Computer will mean random play.");
    } else if (currentPage.equals("game")) {
      System.out.println("Select game Type");
      System.out.println("GAME LIST:");
      System.out.println("------------");
      gameSession.getGameTitles();
      System.out.println();
    } else if (currentPage.equals("confirm")) {
      System.out.println("Player one: " + playerOne.getName());
      System.out.println("Player two: " + playerTwo.getName());
      System.out.println("Chosen Game: " + currentGame.getTitle());
      System.out.println();
      System.out.println("Confirm: Yes or No");
    } else if (currentPage.equals("rounds")) {

      //Rounds or Best of
    } else if (currentPage.equals("roundscount")) {

      //Number of rounds/best of
    } else if (currentPage.equals("player1select")) {
      System.out.println("Player One Select:");
      System.out.println(currentGame);
      //playerOne select
    } else if (currentPage.equals("player2select")) {
      System.out.println("Player Two Select:");
      System.out.println(currentGame);
      //playerTwo select
    } else if (currentPage.equals("endgame")) {
      gameSession.playMatch(currentGame, playerOne, playerOneMove, playerTwo, playerTwoMove);
      System.out.println();
      System.out.println(playerOne);
      System.out.println(playerTwo);
      System.out.println();
      System.out.println("Play Again?");
      System.out.println("PLAYER to change players. GAME to change game. AGAIN: same players same game. Or MAIN to return to the Main Menu");
    } else if (currentPage.equals("again")) {
      //play again
    }  else if (currentPage.equals("error")) {
      System.out.println("There was an issue in adding your game.");
    } else {

    }
  }

  public String[] handleInput(String page, String input) {
    String[] result = {"Select: Section or Page", "Select: Particular Page/Selection"};

    if (page.equals("home")) {
      if (input.equals("home")) {
        result[0] = "section";
        result[1] = "home";
        return result;
      } else if (gameSession.getUser(input) != null) {
        playerOne = gameSession.getUser(input);
        result[0] = "page";
        result[1] = "player2";
        return result;
      } else {
        result[0] = "page";
        result[1] = "error";
        return result;
      }
    } else if (page.equals("player2")) {
      if (gameSession.getUser(input) != null) {
        playerTwo = gameSession.getUser(input);
        result[0] = "page";
        result[1] = "game";
        return result;
      } else {
        result[0] = "page";
        result[1] = "error";
        return result;
      }
    } else if (page.equals("game")) {
      if (gameSession.getGame(input) != null) {
        currentGame = gameSession.getGame(input);
        result[0] = "page";
        result[1] = "confirm";
        return result;
      } else {
        result[0] = "page";
        result[1] = "error";
        return result;
      }
    } else if (page.equals("confirm")) {
      if (input.equals("yes")) {
        if (playerOne.equals("computer") && playerTwo.equals("computer")) {
          playerOneMove = currentGame.playRandom();
          playerTwoMove = currentGame.playRandom();
          result[0] = "page";
          result[1] = "endgame";
          return result;
        } else if (playerOne.equals("computer")) {
          playerOneMove = currentGame.playRandom();
          result[0] = "page";
          result[1] = "player2select";
          return result;
        } else {
          result[0] = "page";
          result[1] = "player1select";
          return result;
        }
      } else {
        result[0] = "page";
        result[1] = "home";
        return result;
      }
    } else if (page.equals("rounds")) {
      //Rounds or Best of
    } else if (page.equals("roundscount")) {

      //Number of rounds/best of
    } else if (page.equals("player1select")) {
      String move =  input.substring(0, 1).toUpperCase() + input.substring(1);
      if (currentGame.checkMove(move)) {
        if (playerTwo.equals("computer")) {
          playerOneMove = move;
          playerTwoMove = currentGame.playRandom();
          result[0] = "page";
          result[1] = "endgame";
          return result;
        } else {
          playerOneMove = move;
          result[0] = "page";
          result[1] = "player2select";
          return result;
        }
      } else {
        result[0] = "page";
        result[1] = "player1select";
        return result;
      }
    } else if (page.equals("player2select")) {
      String move =  input.substring(0, 1).toUpperCase() + input.substring(1);
      if (currentGame.checkMove(move)) {
        playerTwoMove = move;
        result[0] = "page";
        result[1] = "endgame";
        return result;
      } else {
        result[0] = "page";
        result[1] = "player2select";
        return result;
      }
    } else if (page.equals("endgame")) {
      if (input.equals("player")) {
        result[0] = "page";
        result[1] = "home";
        return result;
      } if (input.equals("game")) {
        result[0] = "page";
        result[1] = "game";
        return result;
      } if (input.equals("again")) {
        result[0] = "page";
        result[1] = "player1select";
        return result;
      } else {
        result[0] = "section";
        result[1] = "home";
        return result;
      }

    } else if (page.equals("again")) {
      //play again
    }




    if (input.equals("help")) {
      result[0] = "page";
      result[1] = "help";
      return result;
    } else if (input.equals("continue")) {
      result[0] = "section";
      result[1] = "home";
      return result;
    } else {
      result[0] = "page";
      result[1] = "home";
      return result;
    }
  }
}
