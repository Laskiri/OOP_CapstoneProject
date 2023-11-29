package footballPlayer;

import utils.RankUtil;

public class Goalkeeper extends FootballPlayer {
    private int shotStopping;

    public static class Builder extends FootballPlayer.Builder<Builder> {
        private int shotStopping;

        public Builder setRandomStats() {
            int rankBaseRating = RankUtil.getRankValue(this.rank);
            this.shotStopping = (int) (Math.random() * 10) + rankBaseRating;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Goalkeeper build() {
            return new Goalkeeper(this);
        }

    }

    public Goalkeeper(Builder builder) {
        super(builder);
        this.shotStopping = builder.shotStopping;
    }

    @Override
    public String toString() {
        return "Goalkeeper{" +
                "rank=" + getRank() +
                "name=" + getName() +
                ", shotStopping=" + shotStopping +
                '}';
    }

    public void setRandomStats() {
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.shotStopping = (int) (Math.random() * 10) + rankBaseRating;
    }

    public int getShotStopping() {
        return this.shotStopping;
    }

    public int totalStats() {
        return this.shotStopping;
    }

    public void printPlayer() {
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.println("Shot Stopping: " + this.shotStopping);
    }

}
