package com.company;

import com.company.Generators.CreateGame;
import com.company.Generators.CreatePlayer;
import com.company.Interface.Sections;
import com.company.Interface.Splash;
import com.company.Interface.Home;
import com.company.Interface.Options;
import com.company.Interface.Game;

import java.util.*;

public class Session {
  private static Session ourInstance = new Session();

  public static Session getInstance() {
    return ourInstance;
  }
  private HashMap<String, CreatePlayer> users = new HashMap();
  private HashMap<String, CreateGame> gameTypes = new HashMap();

  public void getUsers() {
    Set<String> keys = users.keySet();
    for (String name : keys) {
      System.out.println(users.get(name).toString());
    }
  }

  public void getUserNames() {
    Set<String> keys = users.keySet();
    for (String name : keys) {
      System.out.println(users.get(name).getName());
    }
  }

  public void getGames() {
    Set<String> keys = gameTypes.keySet();
    for (String title : keys) {
      System.out.println(gameTypes.get(title).toString());
    }
  }

  public void getGameTitles() {
    Set<String> keys = gameTypes.keySet();
    for (String name : keys) {
      System.out.println(gameTypes.get(name).getTitle());
    }
  }

  public CreatePlayer getUser(String name) {
    return users.get(name);
  }

  public void addUser(CreatePlayer user) {
    this.users.put(user.getName().toLowerCase(), user);
  }

  public CreateGame getGame (String title) {
    return gameTypes.get(title);
  }

  public void addGame(CreateGame game) { this.gameTypes.put(game.getTitle().toLowerCase(), game); }


  public int newPlayerId() {
    return users.size();
  }

  public void playMatch(CreateGame game, CreatePlayer createPlayer1, String player1move, CreatePlayer createPlayer2, String player2move) {
    System.out.printf("%s %s %s %s %s %s %s%s ", createPlayer1.getName(), "plays", player1move, "and", createPlayer2.getName(), "plays", player2move, ":");
    String result = game.playGame(player1move, player2move);
    if (result.equals("tie")) {
      System.out.println(createPlayer1.getName() + " and " + createPlayer2.getName() + " tie!");
      postMatch(createPlayer1, createPlayer2, true);
    } else if (result.equals("win")) {
      System.out.println(createPlayer1.getName() + " WINS!");
      postMatch(createPlayer1, createPlayer2, false);
    } else {
      System.out.println(createPlayer2.getName() + " WINS!");
      postMatch(createPlayer2, createPlayer1, false);
    }
  }

  public void postMatch(CreatePlayer winner, CreatePlayer loser, boolean tie) {
    Date now = new Date();
    if (tie) {
      winner.updateGames(loser.getName(),"tie", now);
      loser.updateGames(winner.getName(), "tie", now);
    } else {
      winner.updateGames(loser.getName(),"win", now);
      loser.updateGames(winner.getName(), "lose", now);
    }
  }

  public void start(){
    boolean gameBeingPlayed = true;
    Sections splash = Splash.getInstance();
    Sections home = Home.getInstance();
    Sections options = Options.getInstance();
    Sections game = Game.getInstance();
    String currentSection = "splash";
    String previousPage = "home";
    String currentPage = "home";
    CreatePlayer player = new CreatePlayer("Mario");
    addUser(player);
    player = new CreatePlayer("Luigi");
    addUser(player);
    player = new CreatePlayer("Computer");
    addUser(player);
    ArrayList<String> newType = new ArrayList<>(Arrays.asList("Rock", "Bird", "Water"));
    CreateGame newGame = new CreateGame(newType);
    addGame(newGame);
    newType = new ArrayList<>(Arrays.asList("Rock", "Paper", "Scissors"));
    newGame = new CreateGame(newType);
    addGame(newGame);
    Scanner sc = new Scanner(System.in);
    while (gameBeingPlayed) {

      //There's a way to do this drier with create class and passing the splash/home/game class as variables to single function, but I haven't been able to make it work yet.
      if (currentSection.equals("splash")) {
        splash.display(currentPage);
      } else if (currentSection.equals("home")) {
        home.display(currentPage);
      } else if (currentSection.equals("options")) {
        options.display(currentPage);
      } else if (currentSection.equals("game")) {
        game.display(currentPage);
      }

      String input = "";
      try {
        input = sc.nextLine().toLowerCase();
      } catch(InputMismatchException e) {
        System.out.println("Bad Input.");
      }

      //There's a way to do this drier with create class and passing the splash/home/game class as variables to single function, but I haven't been able to make it work yet.
      String[] result = {"", ""};
      if (input.equals("quit")) {
        gameBeingPlayed = false;
      } else if (currentSection.equals("splash")) {
        result = splash.handleInput(currentPage, input);
      } else if (currentSection.equals("home")) {
        result = home.handleInput(currentPage, input);
      } else if (currentSection.equals("options")) {
        result = options.handleInput(currentPage, input);
      } else if (currentSection.equals("game")) {
        result = game.handleInput(currentPage, input);
      }

      String tempPage = currentPage;
      if (result[0].equals("section")) {
        currentSection = result[1];
        currentPage = "home";
      } else if (result[0].equals("page")) {
        currentPage = result[1];
      } else {
        currentPage = previousPage;
        tempPage = currentPage;
      }
      previousPage = tempPage;
    }
    sc.close();
    System.out.println("Goodbye");
  }

  private Session() {

  }
}
