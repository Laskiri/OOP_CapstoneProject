public abstract class FootballPlayer {

    private String name = "John Doe";

    private char rank;

    public FootballPlayer (char rank) {
        this.rank = rank;
    }


    void generateName() {
        // Logic for randomly generating a name
        this.name = "";
    }

    void setRandomStats() {
    }

    void setRank(char rank) {
        this.rank = rank;
    }

    void printStats() {
    }

    int totalStats() {
        return 0;
    }

    String getName() {
        return this.name;
    }

    public char getRank() {
        return rank;
    }
}
