public class Midfielder extends FootballPlayer {
    private int passing;

    private int physicality;

    private int speed;

    public Midfielder(char rank) {
        super(rank);
    }

    void setRandomStats() {
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.passing = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    int totalStats() {
        return this.passing + this.physicality + this.speed;
    }

    void printStats() {
        System.out.println(this.getName() + " has the following stats:");
        System.out.println("Passing: " + this.passing);
        System.out.println("Physicality: " + this.physicality);
        System.out.println("Speed: " + this.speed);
    }
}
