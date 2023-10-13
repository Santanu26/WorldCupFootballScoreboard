import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.score.Match;
import org.score.Team;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {

    List<Match> matches;

    @BeforeEach
    void init() {
        matches = new ArrayList<>();
    }

    @Test
    void startGame() {
        Team homeTeam = new Team("Mexico",0);
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
        if (matchNo < matches.size()) {
            matches.remove(matchNo);
        }
        assertEquals(0, matches.size());
    }
}
