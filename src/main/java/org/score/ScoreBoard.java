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
        if (!isValidMatch(matchNo)) {
            System.out.println("Invalid Match input!");
            return;
        }
        matches.remove(matchNo);
    }

    public void updateGame(int matchNo, int homeGoals, int awayGoals) {
        if (!isValidMatch(matchNo)) {
            System.out.println("Invalid Match input!");
            return;
        }
        updateScore(matches.get(matchNo).getHomeTeam(), homeGoals);
        updateScore(matches.get(matchNo).getAwayTeam(), awayGoals);
    }

    private boolean isValidMatch(int matchNo) {
        return matchNo >= 0 && matchNo < matches.size();
    }

    private void updateScore(Team team, int score) {
        int prevScore = team.getScore();
        if (score > prevScore) {
            team.setScore(score);
        }
    }
}
