package team;

import team.teamStats.TeamStats;

public class Team {
    protected int teamNumber;

    protected String name;

    protected char teamRank;

    protected TeamStats teamStats;

    public Team(TeamBuilder builder) {
        this.name = builder.name;
        this.teamRank = builder.teamRank;
        this.teamNumber = builder.teamNumber;
        this.teamStats = builder.teamStats;
    }

    public Team() {
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamNumber=" + teamNumber +
                ", name='" + name + '\'' +
                ", teamRank=" + teamRank +
                ", teamStats=" + teamStats +
                '}' + "\r\n";
    }

    public String getName() {
        return this.name;
    }

    public char getTeamRank() {
        return this.teamRank;
    }

    public int getTeamNumber() {
        return this.teamNumber;
    }
}