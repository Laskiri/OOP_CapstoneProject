package footballPlayer;

import utils.RankUtil;

public class Striker extends FootballPlayer {
    private int shooting;

    private int physicality;

    private int speed;

    public Striker(char rank) {
        super(rank);
    }


    @Override
    public void setRandomStats() {
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
    // still need to make this different depending on rank.
        this.shooting = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    public void printPlayer() {
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.print("Shooting: " + this.shooting);
        System.out.print(", Physicality: " + this.physicality);
        System.out.println(", Speed: " + this.speed);
    }

    public int getShooting() {
        return this.shooting;
    }
    public int getPhysicality() {
        return this.physicality;
    }

    public int getSpeed() {
        return this.speed;
    }


    public int totalStats() {
        return this.shooting + this.physicality + this.speed;
    }
}


