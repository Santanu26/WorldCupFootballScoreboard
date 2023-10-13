import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.score.Match;
import org.score.ScoreBoard;
import org.score.Team;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ScoreBoardTest {

    List<Match> matches;

    @BeforeEach
    void init() {
        matches = new ArrayList<>();
    }

    @Test
    void startGame() {
        Team homeTeam = new Team("Mexico", 0);
        Team awayTeam = new Team("Canada", 0);
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        int totalMatch = 1;
        assertEquals(totalMatch, matches.size());
        int initialScore = 0;
        assertEquals(initialScore, homeTeam.getScore());
        assertEquals(initialScore, awayTeam.getScore());
    }

    //Finish a game:
    // It will remove a match from the scoreboard.
    @Test
    void finishGame() {
        int matchNo = 0;
        matches.remove(matchNo);
        assertEquals(0, matches.size());
    }

    @Test
    void updateScore() {
        startGame();
        int matchNo = 0;
        int homeGoals = 1;
        int awayGoals = 0;

        Match match = matches.get(matchNo);
        match.getHomeTeam().setScore(homeGoals);
        match.getAwayTeam().setScore(awayGoals);

        assertNotEquals(1, match.getAwayTeam().getScore());
        assertNotEquals(0, match.getHomeTeam().getScore());

        assertEquals(1, match.getHomeTeam().getScore());
    }
}
