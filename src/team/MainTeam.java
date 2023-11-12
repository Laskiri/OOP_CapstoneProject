package team;

import footballPlayer.*;

import java.util.*;

public class MainTeam extends Team {
    private FootballPlayer[] footballPlayers = new FootballPlayer[20];
    private FootballPlayer[] startingEleven = new FootballPlayer[11];
    private int defendersCount;
    private int midfieldersCount;
    private int strikersCount;
    private int goalkeeperCount = 1;


    @Override
    public String toString() {
        return "MainTeam{" +
                "name='" + this.getName() + '\'' +
                ", teamRank=" + this.getTeamRank() +
                '}' + "\r\n";
    }
    public void addFootballPlayer(int i, FootballPlayer player) {
        this.footballPlayers[i] = player;
    }

    public void choseFormation() {
        Scanner scanner = new Scanner(System.in);
        while(this.defendersCount + this.midfieldersCount + this.strikersCount + this.goalkeeperCount != 11) {
            System.out.println("Please enter the number of defenders for your starting 11: ");
            this.defendersCount = scanner.nextInt();
            System.out.println("Please enter the number of midfielders for your starting 11: ");
            this.midfieldersCount = scanner.nextInt();
            System.out.println("Please enter the number of strikers for your starting 11: ");
            this.strikersCount = scanner.nextInt();
            if(this.defendersCount + this.midfieldersCount + this.strikersCount + this.goalkeeperCount != 11) {
                System.out.println("The number of players in the starting eleven must be 11! Please try again");
            }
        }
    }

    public FootballPlayer[] getFootballPlayers() {
        return footballPlayers;
    }

    public int getDefendersCount() {
        return defendersCount;
    }

    public int getMidfieldersCount() {
        return midfieldersCount;
    }

    public int getStrikersCount() {
        return strikersCount;
    }

    public int getGoalkeeperCount() {
        return goalkeeperCount;
    }

    public void changeStartingPlayer(int i, FootballPlayer player) {
        this.startingEleven[i] = player;
    }




    public void printStartingEleven() {
        System.out.println("The starting eleven is: ");
        for (FootballPlayer player : startingEleven) {
            player.printPlayer();
        }
    }

    public void printAllFootballPlayers() {
        int i = 0;
        System.out.println("All football players on " + this.getName() + " is: ");
        for (FootballPlayer player : footballPlayers) {
            /*System.out.println(player);*/
            System.out.print(player.getClass().getSimpleName() + " - " + player.getName() + ": with the total stats: " + player.totalStats() + "    ");
            if (++i % 2 == 0) {
                System.out.println();
            }
        }
    }





    public void setTeamStats() {
        for (FootballPlayer player : startingEleven) {
            if(player instanceof Striker) {
                this.totalShooting += player.getShooting();
                this.totalPhysicality += player.getPhysicality();
                this.totalSpeed += player.getSpeed();
            } else if(player instanceof Midfielder) {
                this.totalPassing += player.getPassing();
                this.totalPhysicality += player.getPhysicality();
                this.totalSpeed += player.getSpeed();
            } else if(player instanceof Defender) {
                this.totalDefending += player.getDefending();
                this.totalPhysicality += player.getPhysicality();
                this.totalSpeed += player.getSpeed();
            } else if(player instanceof Goalkeeper) {
                this.totalShotStopping += player.getShotStopping();
            }
            else {
                System.out.println("Error: Player is not of any known class");
            }
        }
    }
}
