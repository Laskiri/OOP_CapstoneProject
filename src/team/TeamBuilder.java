package team;

import java.util.Random;
import utils.RandomGenerationUtil;

public class TeamBuilder {
    String name;
    char teamRank;

    public TeamBuilder setRandomName() {


        // Combine them to form the full name
        this.name = RandomGenerationUtil.generateTeamName();
        return this;
    }

    public TeamBuilder setRandomRank() {
        this.teamRank = RandomGenerationUtil.generateRank();
        return this;
    }

    public TeamBuilder setRank(char rank) {
        this.teamRank = rank;
        return this;
    }

    public Team build() {
        return new Team(this);
    }


}