package footballPlayer;

public class Goalkeeper extends FootballPlayer {
    private int shotStopping;

    
    public Goalkeeper(char rank){
        super(rank);
    }

    public void setRandomStats(){
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.shotStopping = (int) (Math.random() * 10) + rankBaseRating;
    }

    public int getShotStopping() {
        return this.shotStopping;
    }

    public int totalStats() {
        return this.shotStopping;
    }

    public void printPlayer(){
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.println("Shot Stopping: " + this.shotStopping);
    }

}
