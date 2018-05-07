package com.company.Interface;

public class Home implements Sections {
  private static Home ourInstance = new Home();

  public static Home getInstance() {
    return ourInstance;
  }

  public void display(String currentPage) {
    if (currentPage.equals("home")) {
      System.out.println("Main Menu");
      System.out.println("----------");
      System.out.println("PLAY");
      System.out.println("OPTIONS");
      System.out.println("Help | Quit");
    } else {
      System.out.println("Help Page");
      System.out.println("Type Play to play game of Rock, Paper, Scissors or a derivation");
      System.out.println("Type Options to: ");
      System.out.println("                - Add new game types");
      System.out.println("                - View games and rules");
      System.out.println("                - Add new players");
      System.out.println("                - View players and their previous games");
      System.out.println("Type Quit to quit at any time.");
      System.out.println("All information is erased upon quitting.");
      System.out.println("Play | Options | Quit");
    }
  }

  public String[] handleInput(String currentPage, String input) {
    String[] result = {"Select: Section or Page", "Select: Particular Page/Selection"};
    if (input.equals("help")) {
      result[0] = "page";
      result[1] = "help";
      return result;
    } else if (input.equals("play")) {
      result[0] = "section";
      result[1] = "game";
      return result;
    } else if (input.equals("options")) {
      result[0] = "section";
      result[1] = "options";
      return result;
    } else {
      result[0] = "page";
      result[1] = "home";
      return result;
    }
  }

  private Home() {
  }
}
