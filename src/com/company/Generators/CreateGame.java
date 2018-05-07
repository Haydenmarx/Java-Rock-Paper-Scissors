package com.company.Generators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CreateGame {
  private HashMap<String, String[]> Game = new HashMap();
  private  ArrayList<String> moves = new ArrayList<>();

  public String getTitle() {
    return title;
  }

  private String title = "";

  public CreateGame(ArrayList<String> choices) {
    StringBuilder title = new StringBuilder();
    int size = choices.size();
    if (size == 5) {
      for (int index = 0; index < size; index++) {
        String name = choices.get(index);
        moves.add(name);
        /* https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java/3904607 */
        title.append(name.substring(0, 1).toUpperCase());
        title.append(name.substring(1));
        title.append(" ");
        String beat1 = choices.get(index + 1 < size ? index + 1 : index - 4);
        String beat2 = choices.get(index + 3 < size ? index + 3 : index - 2);
        String[] temp = {beat1, beat2};
        Game.put(name, temp);
      }
    } else if (size == 3) {
      for (int index = 0; index < size; index++) {
        String name = choices.get(index);
        moves.add(name);
        title.append(name.substring(0, 1).toUpperCase());
        title.append(name.substring(1));
        title.append(" ");
        String beat1 = choices.get(index + 1 < size ? index + 1 : index - 2);
        String[] temp = {beat1, beat1};
        Game.put(name, temp);
      }
    }
    this.title = title.toString().substring(0, title.length() -1);
  }

  public boolean checkMove(String move) {
    return Game.get(move) != null;
  }

  public String playRandom() {
    int choice = (int) Math.floor(Math.random() * moves.size());
    return moves.get(choice);
  }

  public String playGame(String player1, String player2) {
    if (player1.equals(player2)) {
      return "tie";
    }
    if (Game.size() == 5) {
      return Game.get(player1)[0].equals(player2)  || Game.get(player1)[1].equals(player2) ? "win" : "lose";
    } else {
      return Game.get(player1)[0].equals(player2) ? "win" : "lose";
    }
  }

  @Override
  public String toString() {
    Set keys = Game.keySet();
    StringBuilder returnString = new StringBuilder();
    returnString.append("--------------------------------\n");
    returnString.append("---------Winning Moves----------\n");
    returnString.append("  for " + title + "\n");
    returnString.append("--------------------------------\n");
    if (Game.size() == 5) {
      for (Object key : keys) {
        returnString.append(String.format("%s %s %s %s %s%s\n", key, "beats", Game.get(key)[0], "and", Game.get(key)[1], "!"));
      }
    } else {
      for (Object key : keys) {
        returnString.append(String.format("%s %s %s%s\n", key, "beats", Game.get(key)[0], "!"));
      }
    }
    returnString.append("--------------------------------\n");
    returnString.append("--------------------------------\n");
    returnString.append("--------------------------------\n");

    return returnString.toString();
  }
}
