public class Striker extends FootballPlayer {
    private int shooting;

    private int physicality;

    private int speed;

    public Striker(char rank) {
        super(rank);
    }


    @Override
    void setRandomStats() {
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
    // still need to make this different depending on rank.
        this.shooting = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    void printStats() {
        System.out.println(this.getName() + " has the following stats:");
        System.out.println("Shooting: " + this.shooting);
        System.out.println("Physicality: " + this.physicality);
        System.out.println("Speed: " + this.speed);
    }

    int totalStats() {
        return this.shooting + this.physicality + this.speed;
    }
}


