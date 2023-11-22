package team;

public class Formation {
    private int goalkeeperCount = 1;
    private int defendersCount = 4;
    private int midfieldersCount = 4;
    private int strikersCount = 4;

    public Formation(int defendersCount, int midfieldersCount, int strikersCount) {
        this.defendersCount = defendersCount;
        this.midfieldersCount = midfieldersCount;
        this.strikersCount = strikersCount;
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

    public void increaseDefenders() {
        this.defendersCount++;
    }

    public void increaseMidfielders() {
        this.midfieldersCount++;
    }

    public void increaseStrikers() {
        this.strikersCount++;
    }

    public void decreaseDefenders() {
        this.defendersCount--;
    }

    public void decreaseMidfielders() {
        this.midfieldersCount--;
    }

    public void decreaseStrikers() {
        this.strikersCount--;
    }

}
