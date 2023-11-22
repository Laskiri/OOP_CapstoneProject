
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
            this.teams[i] = new TeamBuilder().setRandomName().setRandomRank().setTeamStats().build();
        }
        return this;
    }

    public LeagueBuilder selectMainTeam() {
        UserInterface ui = new UserInterface();
        ui.printTeams(this.teams);
        int teamNumber = ui.getTeamChoice(this.teams);

        this.chosenTeam = new MainTeamEnhancer(this.teams[teamNumber])
                .generateFirst20Players()
                .initializeStartingEleven()
                .getEnhancedTeam();
        MainTeamHelper mainTeamHelper = new MainTeamHelper(this.chosenTeam);
        mainTeamHelper.setupTeam();
        this.teams[teamNumber] = this.chosenTeam;
        ui.chosenTeamMessage(this.chosenTeam.getName());
        return this;
    }

    public League build() {
        return new League(this);
    }
}
