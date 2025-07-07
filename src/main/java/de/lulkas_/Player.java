package de.lulkas_;

public class Player {
    private final String name;
    private boolean imposter = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isImposter() {
        return imposter;
    }

    public void makeImposter() {
        this.imposter = true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", imposter=" + imposter +
                '}';
    }
}
