// This is the file in which the program will run

import java.util.HashMap;
import java.util.Scanner;

public class FootballSimulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Welcome to the Football Simulator!");
        System.out.println("Please enter the name of your league: ");
        String leagueName = scanner.nextLine(); // Read user input
        League league = new League(leagueName);
        System.out.println("The name of your League is: " + league.getLeagueName());
        league.generateTeams();
        System.out.println("The teams in your league are: ");
        league.printTeams();
        league.choseTeam();
        MainTeam team = (MainTeam) league.chosenTeam;
        league.distributeTeamRanks();
        team.generateFirst20Players();
        team.sortFootballPlayersByClass();
        team.printAllFootballPlayers();
        team.choseFormation();
        team.bestStartingEleven();


        System.out.println("We have made the best starting eleven for you, here it is:");
        team.printStartingEleven();

        league.InitializeLeagueTeamStats();
        league.printTeamsStats();




        /* 1. Prompt the player an introduction to the league
        , ask them to give the new league a name or have the name made 'randomly' /*

        /* 2. When a league is created, 12-20 teams should be randomly generated for the league */


        // Testing fo some stuff






    }
}