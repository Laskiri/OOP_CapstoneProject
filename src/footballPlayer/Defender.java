package footballPlayer;

import utils.RankUtil;

public class Defender extends FootballPlayer {
    private int defending;
    private int physicality;
    private int speed;

    public static class Builder extends FootballPlayer.Builder<Builder> {
        private int defending;
        private int physicality;
        private int speed;

        public Builder setRandomStats() {
            int rankBaseRating = RankUtil.getRankValue(this.rank);
            this.defending = (int) (Math.random() * 10) + rankBaseRating;
            this.physicality = (int) (Math.random() * 10) + rankBaseRating;
            this.speed = (int) (Math.random() * 10) + rankBaseRating;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Defender build() {
            return new Defender(this);
        }
    }

    public Defender(Builder builder) {
        super(builder);
        this.defending = builder.defending;
        this.physicality = builder.physicality;
        this.speed = builder.speed;
    }

    @Override
    public String toString() {
        return "Defender{" +
                "name=" + getName() +
                ", rank=" + getRank() +
                ", defending=" + defending +
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

    public int getDefending() {
        return this.defending;
    }

    public void setRandomStats() {
        int rankBaseRating = RankUtil.getRankValue(this.getRank());
        this.defending = (int) (Math.random() * 10) + rankBaseRating;
        this.physicality = (int) (Math.random() * 10) + rankBaseRating;
        this.speed = (int) (Math.random() * 10) + rankBaseRating;
    }

    public int totalStats() {
        return this.defending + this.physicality + this.speed;
    }

    public void printPlayer() {
        System.out.print(this.getClass().getSimpleName() + " - ");
        System.out.print(this.getName() + " has the following stats: ");
        System.out.print("Defending: " + this.defending);
        System.out.print(", Physicality: " + this.physicality);
        System.out.println(", Speed: " + this.speed);
    }
}