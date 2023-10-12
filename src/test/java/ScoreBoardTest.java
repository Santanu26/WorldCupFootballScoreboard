import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.score.Match;

import java.util.ArrayList;
import java.util.List;

class ScoreBoardTest {

    List<Match> matches;

    @BeforeEach
    void init() {
        matches = new ArrayList<>();
    }

    @Test
    void startGame() {
        String homeTeam = "Mexico";
        String awayTeam = "Canada";
        int initialScore = 0;
        Match match = new Match(homeTeam, awayTeam);
        // TODO: add score in the home and away team.
        matches.add(match);
    }
}
