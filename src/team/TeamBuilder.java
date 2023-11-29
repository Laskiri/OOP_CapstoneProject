package team;

import java.util.Random;
import utils.RandomGenerationUtil;
import utils.RankUtil;

public class TeamBuilder {
    int teamNumber;
    String name;
    char teamRank;
    int totalShooting;
    int totalDefending;
    int totalPassing;
    int totalShotStopping;
    int totalPhysicality;
    int totalSpeed;

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
        this.totalShooting = 3 * rankBaseRating;
        this.totalDefending = 3 * rankBaseRating;
        this.totalPassing = 4 * rankBaseRating;
        this.totalShotStopping = 1 * rankBaseRating;
        this.totalPhysicality = 10 * rankBaseRating;
        this.totalSpeed = 10 * rankBaseRating;
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