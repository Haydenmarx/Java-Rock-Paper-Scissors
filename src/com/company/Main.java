package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //https://www.reddit.com/r/javaexamples/comments/336epj/getting_input_from_the_console_validating_and/
    UserInterface images = new UserInterface();
    images.printLogo();
    Scanner sc = new Scanner(System.in);
    while (sc.nextLine() != "quit") {
      System.out.println("Play, Leader Board, Options or Quit:");
      String choice = sc.nextLine().toLowerCase();
      if (choice.equals("play")) {

        //number of players 1-2

        //username/s 1 if 1 or 2 if 2.
          //also list usernames
          //computer is computer
          //guest is available
          //make sure users can't be protected usernames

        //list games and 3 or 5 choices
          //user picks game

        //pick rounds/best of
        //if player picks even number with best of question if they're sure they want to play best of to an even number.

        //DO BEST OUT OF WHERE ONE PLAYER ONLY NEEDS TO WIN THE MAJORITY while (player1total < rounds/2 || player2total < rounds/2)
        //while round < rounds && !choice.equals("quit")
          //player 1 selects
          //if player 2 is not computer they select
          //they can choose help to get information
          //if round +1 === rounds offer rematch.
            //Also display the winner based on who won more rounds.
      } else if (choice.equals("leader board")) {
        //while !choice.equals("return") || !choice.equals("quit")
        //print all user totals --> to string
        //print one users games .displaygames
      } else if (choice.equals("options")) {
        //while !choice.equals("return") || !choice.equals("quit")
        //add user
        //delete user
        //add game
        //delete game
      } else if (choice.equals("quit")) {
        break;
      } else {
        System.out.println("I don't understand " + sc.nextLine() + ". Please use one of the inputs suggested.");
      }
    }
    sc.close();

  }
}


