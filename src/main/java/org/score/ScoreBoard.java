package org.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Match> matches;

    public ScoreBoard() {
        this.matches = new ArrayList<>();
    }

    public void startGame(String homeTeamName, String awayTeamName) {
        Team homeTeam = new Team(homeTeamName, 0);
        Team awayTeam = new Team(awayTeamName, 0);
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    public void finishGame(int matchNo) {
        if (matchNo < matches.size()) {
            matches.remove(matchNo);
        }
    }

}
