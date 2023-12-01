package team;

import team.teamStats.TeamStats;
import utils.RandomGenerationUtil;
import utils.RankUtil;

public class TeamBuilder {
    int teamNumber;
    String name;
    char teamRank;
    TeamStats teamStats = new TeamStats();

    public TeamBuilder setRandomName() {

        // Combine them to form the full name
        this.name = RandomGenerationUtil.generateTeamName();
        return this;
    }

    public TeamBuilder setRandomRank() {
        this.teamRank = RandomGenerationUtil.generateRank();
        return this;
    }

    public TeamBuilder setTeamStats() {
        int rankBaseRating = RankUtil.getRankValue(this.teamRank);
        this.teamStats.setTotalShooting(3 * rankBaseRating);
        this.teamStats.setTotalDefending(3 * rankBaseRating);
        this.teamStats.setTotalPassing(4 * rankBaseRating);
        this.teamStats.setTotalShotStopping(1 * rankBaseRating);
        this.teamStats.setTotalPhysicality(10 * rankBaseRating);
        this.teamStats.setTotalSpeed(10 * rankBaseRating);
        return this;
    }

    public TeamBuilder setRank(char rank) {
        this.teamRank = rank;
        return this;
    }

    public TeamBuilder setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
        return this;
    }

    public Team build() {
        return new Team(this);
    }

}