package team;

public class MainTeamEnhancer {
    private MainTeam mainTeam;
    private MainTeamHelper mainTeamHelper;

    public MainTeamEnhancer(Team team) {
        // Generate starting squad for the team
        this.mainTeam = new MainTeam();
        this.mainTeam.setTeamName(team.getName());

        this.mainTeamHelper = new MainTeamHelper(this.mainTeam);
    }

    public MainTeamEnhancer generateFirst20Players() {
        int i = 0;
        while (i < 6) {
            this.mainTeam.addFootballPlayer(i++, this.mainTeamHelper.generateStriker(this.mainTeam.getTeamRank()));
        }
        while (i < 12) {
            this.mainTeam.addFootballPlayer(i++, this.mainTeamHelper.generateMidfielder(this.mainTeam.getTeamRank()));
        }
        while (i < 18) {
            this.mainTeam.addFootballPlayer(i++, this.mainTeamHelper.generateDefender(this.mainTeam.getTeamRank()));
        }
        while (i < 20) {
            this.mainTeam.addFootballPlayer(i++, this.mainTeamHelper.generateGoalkeeper(this.mainTeam.getTeamRank()));
        }
        // Add your logic for generating the first 20 players here
        return this;
    }

    public MainTeamEnhancer initializeStartingEleven() {
        StartingElevenSquad startingEleven = new StartingElevenSquad(this.mainTeam.getFormation(),
                this.mainTeam.getFootballPlayers());
        this.mainTeam.setStartingEleven(startingEleven);
        return this;
    }

    public MainTeam getEnhancedTeam() {
        return this.mainTeam;
    }
}
