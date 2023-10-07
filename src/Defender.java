public class Defender extends FootballPlayer{
    private int defending;
    private int physicality;
    private int speed;

    public Defender(char rank){
        super(rank);
    }

    void setRandomStats(){
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.defending = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    int totalStats() {
        return this.defending + this.physicality + this.speed;
    }

    void printStats(){
        System.out.println(this.getName() + " has the following stats:");
        System.out.println("Defending: " + this.defending);
        System.out.println("Physicality: " + this.physicality);
        System.out.println("Speed: " + this.speed);
    }
}