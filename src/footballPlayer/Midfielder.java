package footballPlayer;

import utils.RankUtil;

public class Midfielder extends FootballPlayer {
    private int passing;

    private int physicality;

    private int speed;

    public static class Builder extends FootballPlayer.Builder<Builder> {
        private int passing;
        private int physicality;
        private int speed;

        public Builder setRandomStats() {
            int rankBaseRating = RankUtil.getRankValue(this.rank);
            this.passing = (int) (Math.random() * 10) + rankBaseRating;
            this.physicality = (int) (Math.random() * 10) + rankBaseRating;
            this.speed = (int) (Math.random() * 10) + rankBaseRating;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Midfielder build() {
            return new Midfielder(this);
        }
    }

    public Midfielder(Builder builder) {
        super(builder);
        this.passing = builder.passing;
        this.physicality = builder.physicality;
        this.speed = builder.speed;
    }

    @Override
    public String toString() {
        return "Midfielder{" +
                "rank=" + getRank() +
                "name=" + getName() +
                ", passing=" + passing +
                ", physicality=" + physicality +
                ", speed=" + speed +
                '}';
    }

    public int getPhysicality() {
        return this.physicality;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getPassing() {
        return this.passing;
    }

    public void setRandomStats() {
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.passing = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    public int totalStats() {
        return this.passing + this.physicality + this.speed;
    }

    public void printPlayer() {
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.print("Passing: " + this.passing);
        System.out.print(", Physicality: " + this.physicality);
        System.out.println(", Speed: " + this.speed);
    }
}
