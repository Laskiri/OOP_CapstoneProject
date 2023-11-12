package team;

import utils.RankUtil;

public class Team {

    public Team (TeamBuilder builder) {
        this.name = builder.name;
        this.teamRank = builder.teamRank;
    }
    public Team() {
        this.teamRank = 'A';
    }
    private String name;

    private char teamRank;

    protected int totalShooting;

    protected int totalDefending;

    protected int totalPassing;

    protected int totalShotStopping;

    protected int totalPhysicality;

    protected int totalSpeed;

    private int points = 0;

    private int goalsFor = 0;

    private int goalsAgainst = 0;


    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", teamRank=" + teamRank +
                '}' + "\r\n";
    }

    public void setTeamRank(char rank) {
        this.teamRank = rank;
    }

    public String getName() {
        return this.name;
    }

    public void setTeamName(String name) {
        this.name = name;
    }


    char getTeamRank() {
        return this.teamRank;
    }

    public void setTeamStats() {
        int rankBaseRating = RankUtil.getRankValue(this.teamRank);
        this.totalShooting = 3 * rankBaseRating;
        this.totalDefending = 3 * rankBaseRating;
        this.totalPassing = 4 * rankBaseRating;
        this.totalShotStopping = 1 * rankBaseRating;
        this.totalPhysicality = 10 * rankBaseRating;
        this.totalSpeed = 10 * rankBaseRating;
    }

    public void printTeamStats() {
        System.out.println("Team Name: " + this.name);
        System.out.println("Team Rank: " + this.teamRank);
        System.out.println("Team Stats: ");
        System.out.println("Total Shooting: " + this.totalShooting);
        System.out.println("Total Defending: " + this.totalDefending);
        System.out.println("Total Passing: " + this.totalPassing);
        System.out.println("Total Shot Stopping: " + this.totalShotStopping);
        System.out.println("Total Physicality: " + this.totalPhysicality);
        System.out.println("Total Speed: " + this.totalSpeed);
    }


    int getPoints() {
        return this.points;
    }




}
