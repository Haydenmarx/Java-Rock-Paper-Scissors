package com.company.Interface;

public class Splash implements Sections {
  private static Splash ourInstance = new Splash();

  public static Splash getInstance() {
    return ourInstance;
  }

  private Splash() {
  }

  public void display(String currentPage) {
    if (currentPage.equals("home")) {
      printLogo();
    } else {
      System.out.println("Help Page");
      System.out.println("Type Quit to quit at any time.");
      System.out.println("All information is erased upon quitting.");
      System.out.println("Help menus are context specific");
      System.out.println("Continue | Quit");
    }
  }

  private String[] rock = {
   "     ***** ***                          *           ",
   "  ******  * **                        **            ",
   " **   *  *  **                        **            ",
   "*    *  *   **                        **            ",
   "    *  *    *      ****               **            ",
   "   ** **   *      * ***  *    ****    **  ***       ",
   "   ** **  *      *   ****    * ***  * ** * ***      ",
   "   ** ****      **    **    *   ****  ***   *       ",
   "   ** **  ***   **    **   **         **   *        ",
   "   ** **    **  **    **   **         **  *         ",
   "   *  **    **  **    **   **         ** **         ",
   "      *     **  **    **   **         ******        ",
   "  ****      ***  ******    ***     *  **  ***       ",
   " *  ****    **    ****      *******   **   *** *    ",
   "*    **     *                *****     **   ***     ",
   "*                                                   ",
   " **                                                 "
  };
  private String[] paper = {
   "        ***** **                                                 ",
   "     ******  ****                                                ",
   "    **   *  *  ***                                               ",
   "   *    *  *    ***                                              ",
   "       *  *      **               ****              ***  ****    ",
   "      ** **      **    ****      * ***  *    ***     **** **** * ",
   "      ** **      **   * ***  *  *   ****    * ***     **   ****  ",
   "    **** **      *   *   ****  **    **    *   ***    **         ",
   "   * *** **     *   **    **   **    **   **    ***   **         ",
   "      ** *******    **    **   **    **   ********    **         ",
   "      ** ******     **    **   **    **   *******     **         ",
   "      ** **         **    **   **    **   **          **         ",
   "      ** **         **    **   *******    ****    *   ***        ",
   "      ** **          ***** **  ******      *******     ***       ",
   " **   ** **           ***   ** **           *****                ",
   "***   *  *                     **                                ",
   " ***    *                      **                                ",
   "  ******                        **                               ",
   "    ***                                                          "
  };

  private String[] scissors = {
   "      *******                                                                                ",
   "    *       ***               *                                                              ",
   "   *         **              ***                                                             ",
   "   **        *                *                                                              ",
   "    ***                                ****       ****       ****    ***  ****       ****    ",
   "   ** ***           ****    ***       * **** *   * **** *   * ***  *  **** **** *   * **** * ",
   "    *** ***        * ***  *  ***     **  ****   **  ****   *   ****    **   ****   **  ****  ",
   "      *** ***     *   ****    **    ****       ****       **    **     **         ****       ",
   "        *** ***  **           **      ***        ***      **    **     **           ***      ",
   "          ** *** **           **        ***        ***    **    **     **             ***    ",
   "           ** ** **           **          ***        ***  **    **     **               ***  ",
   "            * *  **           **     ****  **   ****  **  **    **     **          ****  **  ",
   "  ***        *   ***     *    **    * **** *   * **** *    ******      ***        * **** *   ",
   " *  *********     *******     *** *    ****       ****      ****        ***          ****    ",
   "*     *****        *****       ***                                                           ",
   "*                                                                                            ",
   " **                                                                                          "
  };


  public void printLogo() {
//      System.out.println();
//      System.out.println();
//      System.out.println();
    for (int x= 0; x < rock.length; x++) {
      System.out.println("|  " + rock[x] + paper[x] + "  |" );
    }
    for (int x= 0; x < rock.length; x++) {
      System.out.println("|  " + "            " + scissors[x] + "            " + "  |" );
    }
    System.out.println("|                             Please set terminal size so the outline fits with no extra space                            |");
    System.out.println("|                                                   Continue | Help | Quit                                                |");
    System.out.println("<------------------------------------------------------------------------------------------------------------------------->");
  }

  public String[] handleInput(String page, String input) {
    String[] result = {"Select: Section or Page", "Select: Particular Page/Selection"};
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
