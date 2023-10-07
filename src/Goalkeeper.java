public class Goalkeeper extends FootballPlayer{
    private int shotStopping;


    public Goalkeeper(char rank){
        super(rank);
    }

    void setRandomStats(){
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.shotStopping = (int) (Math.random() * 10) + rankBaseRating;
    }

    int totalStats() {
        return this.shotStopping;
    }

    void printStats(){
        System.out.println(this.getName() + " has the following stats:");
        System.out.println("Shot Stopping: " + this.shotStopping);
    }
}
