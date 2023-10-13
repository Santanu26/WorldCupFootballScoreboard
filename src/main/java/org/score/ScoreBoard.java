package org.score;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {

    private final Map<Integer, Match> matches;

    public ScoreBoard() {
        this.matches = new LinkedHashMap<>();
    }

    public Map<Integer, Match> getMatches() {
        return matches;
    }

    public void startGame(String homeTeamName, String awayTeamName) {
        Team homeTeam = new Team(homeTeamName, 0);
        Team awayTeam = new Team(awayTeamName, 0);
        Match match = new Match(homeTeam, awayTeam);

        matches.put(matches.size() + 1, match);
    }

    public void finishGame(int matchNo) {
        if (matches.isEmpty()) {
            System.out.println("Invalid Match input!");
            return;
        }
        matches.remove(matchNo);
    }

    public void updateGame(int matchNo, int homeGoals, int awayGoals) {
        if (!isValidMatch(matchNo)) {
            return;
        }
        updateScore(matches.get(matchNo).getHomeTeam(), homeGoals);
        updateScore(matches.get(matchNo).getAwayTeam(), awayGoals);
    }

    private boolean isValidMatch(int matchNo) {
        return matches.containsKey(matchNo);
    }

    private void updateScore(Team team, int score) {
        int prevScore = team.getScore();
        if (score > prevScore) {
            team.setScore(score);
        }
    }

    public void matchSummary() {
        LinkedHashMap<Integer, Match> sortedMatches = sortByTotalScoreDescending(matches);
        printMatchSummary(sortedMatches);
    }

    private LinkedHashMap<Integer, Match> sortByTotalScoreDescending(Map<Integer, Match> matches) {
        // Convert the entry set to a list for sorting
        List<Map.Entry<Integer, Match>> entryList = new ArrayList<>(matches.entrySet());

        // Sort the entry list by total score in descending order
        entryList.sort((match1, match2) -> {
            int totalScore1 = getTotalScore(match1.getValue().getHomeTeam(), match1.getValue().getAwayTeam());
            int totalScore2 = getTotalScore(match2.getValue().getHomeTeam(), match2.getValue().getAwayTeam());

            int scoreComparison = Integer.compare(totalScore2, totalScore1);

            if (scoreComparison == 0) {
                return match2.getKey().compareTo(match1.getKey());
            }
            return scoreComparison;
        });

        LinkedHashMap<Integer, Match> sortedMap = new LinkedHashMap<>();
        entryList.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }

    private int getTotalScore(Team homeTeam, Team awayTeam) {
        return homeTeam.getScore() + awayTeam.getScore();
    }

    private void printMatchSummary(Map<Integer, Match> matches) {
        int rank = 1;
        for (Map.Entry<Integer, Match> match : matches.entrySet()) {
            System.out.println(rank + ". " + match.getValue());
            rank++;
        }
    }
}
