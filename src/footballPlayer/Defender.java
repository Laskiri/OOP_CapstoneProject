package footballPlayer;

public class Defender extends FootballPlayer {
    private int defending;
    private int physicality;
    private int speed;

    public Defender(char rank){
        super(rank);
    }

    public int getPhysicality() {
        return this.physicality;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getDefending() {
        return this.defending;
    }

    public void setRandomStats(){
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.defending = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    public int totalStats() {
        return this.defending + this.physicality + this.speed;
    }

    public void printPlayer(){
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.print("Defending: " + this.defending);
        System.out.print(", Physicality: " + this.physicality);
        System.out.println(", Speed: " + this.speed);
    }
}