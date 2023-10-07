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

    void printPlayer(){
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.println("Shot Stopping: " + this.shotStopping);
    }
}
