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

    public String getLeagueName() {
        return this.name;
    }

    public Team[] getTeams() {
        return this.teams;
    }

}
