// This is the file in which the program will run

import java.util.Scanner;

import team.*;
import utils.UserInterface;

public class FootballSimulator {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        ui.printWelcomeMessage();
        String leagueName = ui.getLeagueNameFromUser();
        League league = new LeagueBuilder()
                .setLeagueName(leagueName)
                .generateTeams(12)
                .selectMainTeam()
                .build();
        System.out.println(league.toString());

        ui.printTeamsStats(league.getTeams());

        // Next things to do;
        /*
         * Create league schedule class:
         * - Settup match fixtures for each gameweek
         * - Assign home and away team to each match, all teams plays against eachother
         * home and away
         * Create league scoreboard class:
         * - Should display the teams from 1-12 based on amount of points,
         * - Gets updated after each gameweek.
         * Implement playNextGameweek method on League class
         * - Matches needs to have a method that handle playing the matches.
         * - Team.Team.MainTeam matches should be handled in detail,
         * Sim matches is decided upon a statistical computation based on the 2 team's
         * rank
         * - Matches has a result and a score-line, points and goals are added to the
         * team object after matches.
         *
         *
         */

        // Testing fo some stuff

    }
}