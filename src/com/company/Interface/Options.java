package com.company.Interface;

import com.company.Generators.CreateGame;
import com.company.Generators.CreatePlayer;
import com.company.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Options implements Sections {
  private static Options ourInstance = new Options();
  private Session gameSession = Session.getInstance();

  public static Options getInstance() {
    return ourInstance;
  }

  private Options() {
  }

  public void display(String currentPage) {
    if (currentPage.equals("home")) {
      System.out.println("Add");
      System.out.println("View");
      System.out.println("Home");
    } else if (currentPage.equals("add")) {
      System.out.println("Add a PLAYER or GAME?");
    } else if (currentPage.equals("view")) {
      System.out.println("View PLAYERS or GAMES?");
    } else if (currentPage.equals("addplayer")) {
      System.out.println("Enter the name of the player you wish to add.");
    } else if (currentPage.equals("viewplayers")) {
      System.out.println("PLAYER LIST:");
      System.out.println("------------");
      gameSession.getUsers();
      System.out.println();
      System.out.println("Type return to exit to options menu.");
    } else if (currentPage.equals("addgame")) {
      System.out.println("Enter your choices separated by commas:");
      System.out.println("Example 3: rock,paper,scissors");
      System.out.println("Example 5: rock,lizard,spock,scissors,paper");
    } else if (currentPage.equals("viewgames")) {
      System.out.println("Game LIST:");
      System.out.println("------------");
      gameSession.getGames();
      System.out.println();
      System.out.println("Type return to exit to options menu.");
    } else if (currentPage.equals("success")) {
      //
    } else if (currentPage.equals("error")) {
      System.out.println("There was an issue in adding your game.");
    } else {
      System.out.println("Add > Player > \"Player Name that doesn't already exist\"");
      System.out.println("Add > Game > 3 to 5 values seperated by commas");
      System.out.println("View > Games/Players");
      System.out.println("All information is erased upon quitting.");
      System.out.println("Home | Quit");
    }
  }

  public String[] handleInput(String page, String input) {
    String[] result = {"Select: Section or Page", "Select: Particular Page/Selection"};

    if (page.equals("home") && input.equals("add")) {
      result[0] = "page";
      result[1] = "add";
      return result;
    } else if (page.equals("home") && input.equals("view")) {
      result[0] = "page";
      result[1] = "view";
      return result;
    } else if (page.equals("home") && input.equals("home")) {
      result[0] = "section";
      result[1] = "home";
      return result;
    } else if (page.equals("home") && input.equals("help")) {
      result[0] = "page";
      result[1] = "help";
      return result;
    }

    if (page.equals("add") && input.equals("player")) {
      result[0] = "page";
      result[1] = "addplayer";
      return result;
    } else if(page.equals("add") && input.equals("game")) {
      result[0] = "page";
      result[1] = "addgame";
      return result;
    }

    if (page.equals("view") && input.equals("players")) {
      result[0] = "page";
      result[1] = "viewplayers";
      return result;
    } else if(page.equals("view") && input.equals("games")) {
      result[0] = "page";
      result[1] = "viewgames";
      return result;
    }

    if (page.equals("addplayer")) {
      String name = input.substring(0, 1).toUpperCase() + input.substring(1);
      if (gameSession.getUser(name) == null) {
        CreatePlayer player = new CreatePlayer(name);
        gameSession.addUser(player);
        result[0] = "page";
        result[1] = "viewplayers";
        return result;
      } else {
        result[0] = "page";
        result[1] = "error";
        return result;
      }

    }

    if (page.equals("addgame")) {
      /*  https://stackoverflow.com/questions/7488643/how-to-convert-comma-separated-string-to-arraylist*/
      List<String> gamelist = Arrays.asList(input.split("\\s*,\\s*"));
      ArrayList<String> newGame = new ArrayList<>();
      for (String choice : gamelist) {
        newGame.add(choice);
      }
      System.out.println(newGame + " . " + newGame.size());
      if (newGame.size() != 3 && newGame.size() != 5) {
        result[0] = "page";
        result[1] = "error";
        return result;
      } else {
        CreateGame createdGame = new CreateGame(newGame);
        gameSession.addGame(createdGame);
        result[0] = "page";
        result[1] = "viewgames";
        return result;
      }
    }

    if (page.equals("viewplayers") && input.equals("return")) {
      result[0] = "page";
      result[1] = "home";
      return result;
    } else if (page.equals("viewplayers")) {
      result[0] = "page";
      result[1] = "viewplayers";
      return result;
    }

    if (page.equals("viewgames") && input.equals("return")) {
      result[0] = "page";
      result[1] = "home";
      return result;
    } else if (page.equals("viewgames")) {
      result[0] = "page";
      result[1] = "viewgames";
      return result;
    }

    result[0] = "page";
    result[1] = "home";
    return result;
  }
}
