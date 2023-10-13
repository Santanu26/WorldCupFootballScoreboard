package org.score;
public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.startGame("Mexico", "Canada");
      //  scoreBoard.finishGame(0);
        scoreBoard.updateGame(0, 1,0);
        scoreBoard.updateGame(0, 2,0);
        // critical test case
        scoreBoard.updateGame(0, 1,3);
        scoreBoard.updateGame(0, 2,1);
    }
}