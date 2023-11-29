package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.sun.tools.javac.Main;

import footballPlayer.FootballPlayer;
import team.*;

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

    public void printTeams(Team[] teams) {
        for (int i = 0; i < 12; i++) {
            System.out.println(i + ": " + teams[i].getName());
        }
    }

    public void printTeams(Set<Team> teams) {
        for (Team team : teams) {
            System.out.println(team);
        }
    }
    public void printTeamsStats(Team[] teams) {
        for (int i = 0; i < 12; i++) {
            teams[i].printTeamStats();
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

    public void chosenTeamMessage(String name) {
        System.out.println("You have chosen " + name + " as your team.");
    }

    public void printAllFootballPlayers(MainTeam team) {
        int i = 0;
        System.out.println("All football players on " + team.getName() + " is: ");
        for (FootballPlayer player : team.getFootballPlayers().getAllPlayers()) {
            /* System.out.println(player); */
            System.out.print(player.getClass().getSimpleName() + " - " + player.getName() + ": with the total stats: "
                    + player.totalStats() + "    ");
            if (++i % 2 == 0) {
                System.out.println();
            }
        }
    }



    public void printStartingEleven(MainTeam team) {
        System.out.println("The starting eleven is: ");
        for (FootballPlayer player : team.getStartingEleven().getAllPlayers()) {
            player.printPlayer();
        }
    }

    public Formation getFormation(MainTeam team) {
        Scanner scanner = new Scanner(System.in);
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

}
