package org.score;

public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.updateGame(1, 0, 5);
        // scoreBoard.finishGame(0);
        scoreBoard.updateGame(1, 1, 5);
        scoreBoard.updateGame(1, 2, 5);
        scoreBoard.updateGame(11, 1, 6);
        scoreBoard.updateGame(1, -1, 6);
        scoreBoard.updateGame(0, 4, 6);
        scoreBoard.updateGame(0, 7, 6);

        scoreBoard.startGame("Spain", "Brazil");
        scoreBoard.updateGame(2, 10, 2);
        // scoreBoard.finishGame(1);

        scoreBoard.startGame("Germany", "France");
        scoreBoard.updateGame(3, 2, 2);

        scoreBoard.startGame("Uruguay", "Italy");
        scoreBoard.updateGame(4, 6, 6);

        scoreBoard.startGame("Argentina", "Australia");
        scoreBoard.updateGame(5, 3, 1);
        //scoreBoard.startGame("Argentina", "Australia");
        //scoreBoard.updateGame(5, 0, 0);

        scoreBoard.startGame("England", "France");
        scoreBoard.updateGame(6, 3, 1);
        scoreBoard.finishGame(6);

        scoreBoard.matchSummary();
    }
}