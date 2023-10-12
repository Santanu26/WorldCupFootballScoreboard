package org.score;

public class Team {

    private final String name;

    private final int score;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
