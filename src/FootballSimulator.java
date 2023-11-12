// This is the file in which the program will run

import java.util.Scanner;

import team.*;

public class FootballSimulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Welcome to the Football Simulator! Where you can embark on a journey to bring a team of your choisce to glory!");
        System.out.println("Please enter the desired name for your league: ");
        String leagueName = scanner.nextLine(); // Read user input
        League league = new LeagueBuilder().setLeagueName(leagueName).generateTeams(12).choseTeam().build();
        System.out.println(league.toString());

        MainTeam mainTeam = league.getChosenTeam();

        MainTeamHelper mainTeamHelper = new MainTeamHelper(mainTeam);
        mainTeamHelper.generateFirst20Players(mainTeam);
        mainTeamHelper.sortFootballPlayersByClass(mainTeam);
        mainTeam.printAllFootballPlayers();
        mainTeam.choseFormation();
        mainTeamHelper.makeBestStartingEleven(mainTeam);
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
        *           - Team.Team.MainTeam matches should be handled in detail,
        *             Sim matches is decided upon a statistical computation based on the 2 team's rank
        *           - Matches has a result and a score-line, points and goals are added to the team object after matches.
        *
        *
        *    */





        // Testing fo some stuff






    }
}