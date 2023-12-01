package team.teamStats;

public class TeamStats {
    private int totalShooting;

    private int totalDefending;

    private int totalPassing;

    private int totalShotStopping;

    private int totalPhysicality;

    private int totalSpeed;

    public TeamStats() {
    }

    @Override
    public String toString() {
        return "TeamStats{" +
                "totalShooting=" + totalShooting +
                ", totalDefending=" + totalDefending +
                ", totalPassing=" + totalPassing +
                ", totalShotStopping=" + totalShotStopping +
                ", totalPhysicality=" + totalPhysicality +
                ", totalSpeed=" + totalSpeed +
                '}';
    }

    public int getTotalShooting() {
        return this.totalShooting;
    }

    public void setTotalShooting(int totalShooting) {
        this.totalShooting = totalShooting;
    }

    public int getTotalDefending() {
        return this.totalDefending;
    }

    public void setTotalDefending(int totalDefending) {
        this.totalDefending = totalDefending;
    }

    public int getTotalPassing() {
        return this.totalPassing;
    }

    public void setTotalPassing(int totalPassing) {
        this.totalPassing = totalPassing;
    }

    public int getTotalShotStopping() {
        return this.totalShotStopping;
    }

    public void setTotalShotStopping(int totalShotStopping) {
        this.totalShotStopping = totalShotStopping;
    }

    public int getTotalPhysicality() {
        return this.totalPhysicality;
    }

    public void setTotalPhysicality(int totalPhysicality) {
        this.totalPhysicality = totalPhysicality;
    }

    public int getTotalSpeed() {
        return this.totalSpeed;
    }

    public void setTotalSpeed(int totalSpeed) {
        this.totalSpeed = totalSpeed;
    }

}
