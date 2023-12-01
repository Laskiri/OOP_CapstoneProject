package footballPlayer;

import utils.RankUtil;

public class Striker extends FootballPlayer {
    private int shooting;

    private int physicality;

    private int speed;

    public static class Builder extends FootballPlayer.Builder<Builder> {
        private int shooting;
        private int physicality;
        private int speed;

        public Builder setRandomStats() {
            int rankBaseRating = RankUtil.getRankValue(this.rank);
            this.shooting = (int) (Math.random() * 10) + rankBaseRating;
            this.physicality = (int) (Math.random() * 10) + rankBaseRating;
            this.speed = (int) (Math.random() * 10) + rankBaseRating;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Striker build() {
            return new Striker(this);
        }
    }

    public Striker(Builder builder) {
        super(builder);
        this.shooting = builder.shooting;
        this.physicality = builder.physicality;
        this.speed = builder.speed;
    }

    @Override
    public String toString() {
        return "Striker{" +
                "rank=" + getRank() +
                ", name=" + getName() +
                ", shooting=" + shooting +
                ", physicality=" + physicality +
                ", speed=" + speed +
                '}';
    }

    public void printPlayer() {
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.print("Shooting: " + this.shooting);
        System.out.print(", Physicality: " + this.physicality);
        System.out.println(", Speed: " + this.speed);
    }

    public int getShooting() {
        return this.shooting;
    }

    public int getPhysicality() {
        return this.physicality;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int totalStats() {
        return this.shooting + this.physicality + this.speed;
    }
}
