package footballPlayer;

import java.util.Random;
import utils.RandomGenerationUtil;

public abstract class FootballPlayer {

    private String name;

    private char rank;

    public static abstract class Builder<T extends Builder<T>> {
        private String name;
        protected char rank;

        public T setRandomName() {
            this.name = RandomGenerationUtil.generatePlayerName();
            return self();
        }

        public T rank(char rank) {
            this.rank = rank;
            return self();
        }

        protected abstract T self();

        public abstract FootballPlayer build();
    }

    public FootballPlayer(Builder<?> builder) {
        this.name = builder.name;
        this.rank = builder.rank;

    }

    public void setRandomStats() {
    }

    public void printPlayer() {
    }

    public int totalStats() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public char getRank() {
        return rank;
    }

    public int getShooting() {
        return 0;
    }

    public int getPassing() {
        return 0;
    }

    public int getPhysicality() {
        return 0;
    }

    public int getSpeed() {
        return 0;
    }

    public int getDefending() {
        return 0;
    }

    public int getShotStopping() {
        return 0;
    }
}
