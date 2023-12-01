package league;

import team.*;
import utils.UserInterface;

public class LeagueBuilder {
    String name;

    MainTeam chosenTeam;

    Team[] teams;

    public LeagueBuilder setLeagueName(String name) {
        String newName = name.trim();
        if (name != null && !newName.isEmpty()) {
            this.name = newName;
        }
        return this;
    }

    public LeagueBuilder generateTeams(int teamAmount) {

        if (teamAmount < 8) {
            throw new IllegalArgumentException("League must have at least 2 teams");
        }

        if (teamAmount > 20) {
            throw new IllegalArgumentException("League must have at most 20 teams");
        }

        if (teamAmount % 2 != 0) {
            throw new IllegalArgumentException("League must have an even number of teams");
        }

        this.teams = new Team[(int) teamAmount];
        for (int i = 0; i < teamAmount; i++) {
            this.teams[i] = new TeamBuilder().setTeamNumber(i).setRandomName().setRandomRank().setTeamStats()
                    .build();

        }
        return this;
    }

    public LeagueBuilder selectMainTeam() {
        UserInterface ui = new UserInterface();
        for (Team team : teams) {
            System.out.println(team.toString());
        }

        int teamNumber = ui.getTeamChoice(this.teams);

        this.chosenTeam = new MainTeamEnhancer(this.teams[teamNumber])
                .generateFirst20Players()
                .initializeStartingEleven()
                .getEnhancedTeam();

        this.teams[teamNumber] = this.chosenTeam;

        System.out.println(this.teams[teamNumber].toString());

        return this;
    }

    public League build() {
        return new League(this);
    }
}
