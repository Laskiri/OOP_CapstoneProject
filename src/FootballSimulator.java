// This is the file in which the program will run

import java.util.HashMap;

public class FootballSimulator {
    public static void main(String[] args) {
        /* 1. Prompt the player an introduction to the league
        , ask them to give the new league a name or have the name made 'randomly' /*

        /* 2. When a league is created, 12-20 teams should be randomly generated for the league */


        // Testing fo some stuff

        MainTeam team1 = new MainTeam();

        team1.generateFirst20Players();
        team1.sortFootballPlayersByClass();
        team1.printAllFootballPlayers();
        team1.bestStartingEleven(4, 4, 2);
        team1.printStartingEleven();




    }
}