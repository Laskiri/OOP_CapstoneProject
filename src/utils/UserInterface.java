package utils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import footballPlayer.FootballPlayer;
import team.*;
import team.formation.Formation;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void printWelcomeMessage() {
        System.out.println(
                "Welcome to the Football Simulator! Where you can embark on a journey to bring a team of your choice to glory!");
    }

    public String getLeagueNameFromUser() {
        System.out.println("Please enter the desired name for your league: ");
        return scanner.nextLine();
    }

    public void printTeams(Set<Team> teams) {
        for (Team team : teams) {
            System.out.println(team);
        }
    }

    public int getTeamChoice(Team[] teams) {
        while (true) {
            System.out.println("Please choose the team you would like to manage by entering the number of the team: ");
            try {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice < teams.length) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and " + (teams.length - 1));
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            }
        }
    }

    public Formation getFormation(MainTeam team) {
        int defendersCount, midfieldersCount, strikersCount;
        while (true) {
            try {
                System.out.println("Please enter the number of defenders for your starting 11: ");
                defendersCount = scanner.nextInt();
                if (defendersCount < 0 || defendersCount > team.getFootballPlayers().getDefenders().size()) {
                    throw new IllegalArgumentException(
                            "Invalid number of defenders. Please enter a number between 0 and "
                                    + team.getFootballPlayers().getDefenders().size());
                }

                System.out.println("Please enter the number of midfielders for your starting 11: ");
                midfieldersCount = scanner.nextInt();
                if (midfieldersCount < 0 || midfieldersCount > team.getFootballPlayers().getMidfielders().size()) {
                    throw new IllegalArgumentException(
                            "Invalid number of midfielders. Please enter a number between 0 and "
                                    + team.getFootballPlayers().getMidfielders().size());
                }

                System.out.println("Please enter the number of strikers for your starting 11: ");
                strikersCount = scanner.nextInt();
                if (strikersCount < 0 || strikersCount > team.getFootballPlayers().getStrikers().size()) {
                    throw new IllegalArgumentException(
                            "Invalid number of strikers. Please enter a number between 0 and "
                                    + team.getFootballPlayers().getStrikers().size());
                }

                if (defendersCount + midfieldersCount + strikersCount + 1 == 11) { // +1 for the goalkeeper
                    return new Formation(defendersCount, midfieldersCount, strikersCount);
                } else {
                    System.out.println("The number of players in the starting eleven must be 11! Please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Discard the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void teamSetup(MainTeam team) {
        System.out.println("The current name of your team is: " + team.getName() + "\n"
                + "Would you like to change it? (y/n)");

        String choice = scanner.next();
        if (choice.equals("y")) {
            System.out.println("Please enter the new name for your team: ");
            String newName = scanner.next();
            team.setTeamName(newName);
            System.out.println("Your team name is now: " + team.getName());
        }

        System.out.println("The current formation of your team is: " + team.getFormation() + "\n"
                + "Would you like to change it? (y/n)");
        choice = scanner.next();
        if (choice.equals("y")) {
            Formation formation = getFormation(team);
            team.updateFormation(formation);
            System.out.println("Your formation is now: " + team.getFormation());
        }

        System.out.println("The current starting eleven of your team is: " + team.getStartingEleven() + "\n"
                + "Would you like to make any changes? (y/n)");
        choice = scanner.next();
        if (choice.equals("y")) {
            changeStartingEleven(team);
            System.out.println("Your starting eleven is now: " + team.getStartingEleven());
        }
        System.out.println("Your team is now set up! enjoy the game!");
    }

    public void changeStartingEleven(MainTeam team) {
        List<FootballPlayer> allPlayers = team.getFootballPlayers().getAllPlayers();
        List<FootballPlayer> startingEleven = team.getStartingEleven().getAllPlayers();

        System.out.println("Please enter the number of the player you would like to change: ");
        for (int i = 0; i < startingEleven.size(); i++) {
            System.out.println(i + ": " + startingEleven.get(i));
        }
        int playerNumber = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                playerNumber = scanner.nextInt();
                if (playerNumber < 0 || playerNumber >= startingEleven.size()) {
                    System.out.println("Invalid input. Number must be between 0 and " + (startingEleven.size() - 1));
                    validInput = false;
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        System.out.println("Who would you like to replace " + startingEleven.get(playerNumber) + " with: ");
        for (int i = 0; i < allPlayers.size(); i++) {
            if (!startingEleven.contains(allPlayers.get(i))) {
                System.out.println(i + ": " + allPlayers.get(i));
            }
        }
        int replacementNumber = 0;
        validInput = false;
        FootballPlayer replacement = null;
        while (!validInput) {
            try {
                replacementNumber = scanner.nextInt();
                replacement = team.getFootballPlayers().getFootballPlayer(replacementNumber);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid player number. Please enter a valid player number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        try {
            team.changeStartingPlayer(playerNumber, replacement);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            changeStartingEleven(team);
        }
    }
}
