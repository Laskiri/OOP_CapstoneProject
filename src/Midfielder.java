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

    void printPlayer() {
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.print("Passing: " + this.passing);
        System.out.print(", Physicality: " + this.physicality);
        System.out.println(", Speed: " + this.speed);
    }
}
