import team.MainTeam;
import team.Team;
import team.TeamBuilder;

import java.util.Scanner;

public class LeagueBuilder {

    Scanner scanner = new Scanner(System.in); // Create a Scanner object
    String name;

    MainTeam chosenTeam = new MainTeam();
    Team[] teams;
    public LeagueBuilder setLeagueName(String name) {
        this.name = name;
        return this;
    }

    public LeagueBuilder generateTeams(int teamAmount) {
        this.teams = new Team[teamAmount];
        for (int i = 0; i < teamAmount; i++) {
            this.teams[i] = new TeamBuilder().setRandomName().setRandomRank().build();
        }
        return this;
    }

    public LeagueBuilder choseTeam() {
        for (int i = 0; i < teams.length; i++) {
            System.out.println(i + ": "+ this.teams[i].getName());
        }
        System.out.println("Please choose the team you would like to manage by entering the number of the team: ");
        int teamNumber = scanner.nextInt();
        this.chosenTeam.setTeamName(this.teams[teamNumber].getName());
        this.teams[teamNumber] = this.chosenTeam;
        System.out.println("You have chosen " + this.chosenTeam.getName() + " as your team.");

        return this;
    }

    public League build() {
        return new League(this);
    }
}
