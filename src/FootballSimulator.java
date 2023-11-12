// This is the file in which the program will run

import java.util.Scanner;

public class FootballSimulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Welcome to the Football Simulator! Where you can embark on a journey to bring a team of your choisce to glory!");
        System.out.println("Please enter the desired name for your league: ");
        String leagueName = scanner.nextLine(); // Read user input
        League league = new League(leagueName);
        System.out.println("The name of your League is: " + league.getLeagueName());
        league.generateTeams();
        System.out.println("The teams in your league are: ");
        league.printTeams();
        league.choseTeam();
        MainTeam mainTeam = league.chosenTeam;
        /*league.distributeTeamRanks();*/
        mainTeam.generateFirst20Players();
        mainTeam.sortFootballPlayersByClass();
        mainTeam.printAllFootballPlayers();
        mainTeam.choseFormation();
        mainTeam.bestStartingEleven();
        System.out.println("We have made the best starting eleven for you, here it is:");
        mainTeam.printStartingEleven();
        league.InitializeLeagueTeamStats();
        league.printTeamsStats();

        // Next things to do;
        /* Create league schedule class:
        *      - Settup match fixtures for each gameweek
        *      - Assign home and away team to each match, all teams plays against eachother home and away
        *  Create league scoreboard class:
        *      - Should display the teams from 1-12 based on amount of points,
        *      - Gets updated after each gameweek.
        *  Implement playNextGameweek method on League class
        *      - Matches needs to have a method that handle playing the matches.
        *           - MainTeam matches should be handled in detail,
        *             Sim matches is decided upon a statistical computation based on the 2 team's rank
        *           - Matches has a result and a score-line, points and goals are added to the team object after matches.
        *
        *
        *    */





        // Testing fo some stuff






    }
}