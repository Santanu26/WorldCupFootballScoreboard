import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.score.Match;
import org.score.ScoreBoard;
import org.score.Team;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    Map<Integer, Match> matches;

    private ScoreBoard scoreBoard;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void init() {
        matches = new LinkedHashMap<>();
        scoreBoard = new ScoreBoard();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testStartGame() {
        scoreBoard.startGame("TeamA", "TeamB");
        assertEquals(1, scoreBoard.getMatches().size());
    }

    @Test
    void startGame() {
        Team homeTeam = new Team("Mexico", 0);
        Team awayTeam = new Team("Canada", 0);
        Match match = new Match(homeTeam, awayTeam);
        matches.put(0, match);
        int totalMatch = 1;
        assertEquals(totalMatch, matches.size());
        int initialScore = 0;
        assertEquals(initialScore, homeTeam.getScore());
        assertEquals(initialScore, awayTeam.getScore());
    }

    //Finish a game:
    // It will remove a match from the scoreboard.
    @Test
    public void testFinishGame() {
        scoreBoard.startGame("TeamA", "TeamB");
        scoreBoard.finishGame(1);
        assertTrue(scoreBoard.getMatches().isEmpty());
    }

    @Test
    void finishGame() {
        int matchNo = 0;
        matches.remove(matchNo);
        assertEquals(0, matches.size());
    }

    @Test
    public void testFinishGameWithEmptyMatches() {
        scoreBoard.finishGame(1);

        assertTrue(outputStream.toString().contains("Invalid Match input!"));
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

    @Test
    void testMatchSummary() {
        Match m1 = new Match(new Team("Mexico", 0), new Team("Canada", 0));
        scoreBoard.startGame(m1.getHomeTeam().getName(), m1.getAwayTeam().getName());
        scoreBoard.updateGame(1, 1, 0);

        Match m2 = new Match(new Team("Spain", 0), new Team("Brazil", 0));
        scoreBoard.startGame(m2.getHomeTeam().getName(), m2.getAwayTeam().getName());
        scoreBoard.updateGame(2, 1, 4);
        scoreBoard.updateGame(2, 2, 4);

        Match m3 = new Match(new Team("Spain", 0), new Team("England", 0));
        scoreBoard.startGame(m3.getHomeTeam().getName(), m3.getAwayTeam().getName());
        scoreBoard.updateGame(3, 1, 4);

        scoreBoard.matchSummary();

        assertTrue(outputStream.toString().contains("2. Spain 1 - England 4"));
    }
    @AfterEach
    public void tearDown() throws IOException {
        System.setOut(System.out);
        outputStream.close();
    }
}
