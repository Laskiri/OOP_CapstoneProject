import java.util.*;

public class MainTeam extends Team{
    private FootballPlayer[] footballPlayers = new FootballPlayer[20];
    private FootballPlayer[] startingEleven = new FootballPlayer[11];
    private int defendersCount;
    private int midfieldersCount;
    private int strikersCount;
    private int goalkeeperCount = 1;
    FootballPlayer generateStriker(char rank) {
        FootballPlayer striker = new Striker(rank);
        striker.generateName();
        striker.setRandomStats();
        return striker;

    }

    FootballPlayer generateMidfielder(char rank) {
        FootballPlayer midfielder = new Midfielder(rank);
        midfielder.setRank(rank);
        midfielder.generateName();
        midfielder.setRandomStats();
        return midfielder;
    }

    FootballPlayer generateDefender(char Rank) {
        FootballPlayer defender = new Defender(Rank);
        defender.generateName();
        defender.setRandomStats();
        return defender;
    }

    FootballPlayer generateGoalkeeper(char Rank) {
        FootballPlayer goalkeeper = new Goalkeeper(Rank);
        goalkeeper.generateName();
        goalkeeper.setRandomStats();
        return goalkeeper;
    }


    void generateFirst20Players() {
        int i = 0;
        while(i < 6) {
            this.footballPlayers[i++] = generateStriker('A');
        }
        while(i < 12) {
            this.footballPlayers[i++] = generateMidfielder('A');
        }
        while(i < 18) {
            this.footballPlayers[i++] = generateDefender('A');
        }
        while(i < 20) {
            this.footballPlayers[i++] = generateGoalkeeper('A');
        }
    }

    void choseFormation() {
        Scanner scanner = new Scanner(System.in);
        while(this.defendersCount + this.midfieldersCount + this.strikersCount + this.goalkeeperCount != 11) {
            System.out.println("Please enter the number of defenders for your starting 11: ");
            this.defendersCount = scanner.nextInt();
            System.out.println("Please enter the number of midfielders for your starting 11: ");
            this.midfieldersCount = scanner.nextInt();
            System.out.println("Please enter the number of strikers for your starting 11: ");
            this.strikersCount = scanner.nextInt();
            if(this.defendersCount + this.midfieldersCount + this.strikersCount + this.goalkeeperCount != 11) {
                System.out.println("The number of players in the starting eleven must be 11! Please try again");
            }
        }
    }

    void bestStartingEleven() {
        Scanner scanner = new Scanner(System.in);

        // Check if the total player count matches the required count (11)
        if (this.defendersCount + this.midfieldersCount + this.strikersCount + this.goalkeeperCount != 11) {
            System.out.println("The number of players in the starting eleven must be 11");
            return;
        }

        // Initialize starting eleven array
        startingEleven = new FootballPlayer[11];

        // Create lists for each position
        List<FootballPlayer> defenders = new ArrayList<>();
        List<FootballPlayer> midfielders = new ArrayList<>();
        List<FootballPlayer> strikers = new ArrayList<>();
        List<FootballPlayer> goalkeepers = new ArrayList<>();

        // Iterate through footballPlayers and categorize them by position
        for (FootballPlayer player : footballPlayers) {
            if (player instanceof Defender) {
                defenders.add(player);
            } else if (player instanceof Midfielder) {
                midfielders.add(player);
            } else if (player instanceof Striker) {
                strikers.add(player);
            } else if (player instanceof Goalkeeper) {
                goalkeepers.add(player);
            }
        }

        // Sort each position list by total stats in descending order
        defenders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        midfielders.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        strikers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());
        goalkeepers.sort(Comparator.comparingInt(FootballPlayer::totalStats).reversed());

        // Fill the starting eleven with the best players from each position
        int index = 0;

        startingEleven[index++] = goalkeepers.get(0);
        for (int i = 0; i < defendersCount; i++) {
            startingEleven[index++] = defenders.get(i);
        }
        for (int i = 0; i < midfieldersCount; i++) {
            startingEleven[index++] = midfielders.get(i);
        }
        for (int i = 0; i < strikersCount; i++) {
            startingEleven[index++] = strikers.get(i);
        }

    }


    void printStartingEleven() {
        System.out.println("The starting eleven is: ");
        for (FootballPlayer player : startingEleven) {
            player.printPlayer();
        }
    }

    void printAllFootballPlayers() {
        int i = 0;
        System.out.println("All football players on " + this.getName() + " is: ");
        for (FootballPlayer player : footballPlayers) {
            System.out.print(player.getClass().getSimpleName() + " - " + player.getName() + ": with the total stats: " + player.totalStats() + "    ");
            if (++i % 2 == 0) {
                System.out.println();
            }
        }
    }
    void sortFootballPlayersByClass() {
        Arrays.sort(footballPlayers, (player1, player2) ->
                player1.getClass().getSimpleName().compareTo(player2.getClass().getSimpleName())
        );
    }




    void setTeamStats(int rankBaseRating) {

    }
}
