
import team.*;
import utils.UserInterface;

public class LeagueBuilder {
    String name;

    MainTeam chosenTeam;

    Team[] teams;

    public LeagueBuilder setLeagueName(String name) {
        this.name = name;
        return this;
    }

    public LeagueBuilder generateTeams(int teamAmount) {
        this.teams = new Team[teamAmount];
        for (int i = 0; i < teamAmount; i++) {
            this.teams[i] = new TeamBuilder().setTeamNumber(i).setRandomName().setRandomRank().setTeamStats().build();
        }
        return this;
    }

    public LeagueBuilder selectMainTeam() {
        UserInterface ui = new UserInterface();
        for (Team team : teams) {
            System.out.println(team.toString());
        }

        int teamNumber = ui.getTeamChoice(this.teams);

        System.out.println(this.teams[teamNumber].toString());

        this.chosenTeam = new MainTeamEnhancer(this.teams[teamNumber])
                .generateFirst20Players()
                .initializeStartingEleven()
                .getEnhancedTeam();
        MainTeamHelper mainTeamHelper = new MainTeamHelper(this.chosenTeam);
        mainTeamHelper.setupTeam();
        this.teams[teamNumber] = this.chosenTeam;

        return this;
    }

    public League build() {
        return new League(this);
    }
}
