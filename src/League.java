import team.*;

import java.util.Arrays;
import java.util.Scanner;


public class League {


    private String name;

    private Team[] teams;

    private MainTeam chosenTeam = new MainTeam();

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", teams=" + Arrays.toString(teams) +
                '}';
    }

    public League(LeagueBuilder builder) {
        this.name = builder.name;
        this.teams = builder.teams;
        this.chosenTeam = builder.chosenTeam;
    }

    public MainTeam getChosenTeam() {
        return chosenTeam;
    }

    String getLeagueName() {
        return this.name;
    }

    void printTeams() {
        for (int i = 0; i < 12; i++) {
            System.out.println(i + ": "+ this.teams[i].getName());
        }
    }

    void printTeamsStats() {
        for (int i = 0; i < 12; i++) {
            this.teams[i].printTeamStats();
        }
    }
    void distributeTeamRanks() {
        char[] rankDistribution = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (Team team : teams) {
            if (team != this.chosenTeam) {
                team.setTeamRank(rankDistribution[(int) (Math.random() * 6)]);
            }
            else {
                team.setTeamRank('A');
            }
        }
    }

    void InitializeLeagueTeamStats() {
        for (Team team : teams) {
            team.setTeamStats();
        }
    }




}
