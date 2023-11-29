package team;

import utils.RankUtil;

public class Team {

    public Team(TeamBuilder builder) {
        this.name = builder.name;
        this.teamRank = builder.teamRank;
        this.teamNumber = builder.teamNumber;
        this.totalShooting = builder.totalShooting;
        this.totalDefending = builder.totalDefending;
        this.totalPassing = builder.totalPassing;
        this.totalShotStopping = builder.totalShotStopping;
        this.totalPhysicality = builder.totalPhysicality;
        this.totalSpeed = builder.totalSpeed;
    }

    public Team() {
    }

    private int teamNumber;

    protected String name;

    protected char teamRank;

    protected int totalShooting;

    protected int totalDefending;

    protected int totalPassing;

    protected int totalShotStopping;

    protected int totalPhysicality;

    protected int totalSpeed;

    @Override
    public String toString() {
        return "Team{" +
                "teamNumber=" + teamNumber +
                ", name='" + name + '\'' +
                ", teamRank=" + teamRank +
                ", totalShooting=" + totalShooting +
                ", totalDefending=" + totalDefending +
                ", totalPassing=" + totalPassing +
                ", totalShotStopping=" + totalShotStopping +
                ", totalPhysicality=" + totalPhysicality +
                ", totalSpeed=" + totalSpeed +
                '}' + "\r\n";
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

    public int getTeamNumber() {
        return this.teamNumber;
    }
}