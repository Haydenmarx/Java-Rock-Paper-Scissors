package com.company.Generators;

public class CreateGamesAndUsers {
  private static CreateGamesAndUsers ourInstance = new CreateGamesAndUsers();

  public static CreateGamesAndUsers getInstance() {
    return ourInstance;
  }

  private CreateGamesAndUsers() {
  }
}
