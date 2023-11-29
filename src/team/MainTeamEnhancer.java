package team;

public class MainTeamEnhancer {
    private MainTeam mainTeam;
    private MainTeamHelper mainTeamHelper;

    public MainTeamEnhancer(Team team) {
        // Generate starting squad for the team
        this.mainTeam = new MainTeam();
        this.mainTeam.setTeamName(team.getName());
        this.mainTeam.setTeamRank(team.getTeamRank());
        this.mainTeamHelper = new MainTeamHelper(this.mainTeam);
    }

    public MainTeamEnhancer generateFirst20Players() {
        String[] positions = { "Striker", "Striker", "Striker", "Striker", "Striker", "Striker", "Midfielder",
                "Midfielder", "Midfielder", "Midfielder", "Midfielder", "Midfielder", "Defender", "Defender",
                "Defender", "Defender", "Defender", "Defender", "Goalkeeper", "Goalkeeper" };

        for (int i = 0; i < positions.length; i++) {
            this.mainTeam.addFootballPlayer(i,
                    this.mainTeamHelper.generatePlayer(this.mainTeam.getTeamRank(), positions[i]));
        }
        return this;
    }

    public MainTeamEnhancer initializeStartingEleven() {
        mainTeamHelper.makeBestStartingEleven(this.mainTeam.getFormation(), this.mainTeam.getFootballPlayers());
        return this;
    }

    public MainTeam getEnhancedTeam() {
        return this.mainTeam;
    }
}
