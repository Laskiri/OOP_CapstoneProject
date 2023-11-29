package team;

public interface Observable {
    void addObserver(Observer observer);

    void notifyObservers();
}
