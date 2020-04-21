/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

/**
 *
 * @author julinden
 */
public class GameLogic {
    private int score;
    private Board board;
    private boolean gameOver;
    
    public GameLogic() {
        
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public void newGame(int size) {
        this.board = new Board(size);
        this.gameOver = false;
        this.score = 0;
        board.gridInit();
        board.addRandomTile();
        board.addRandomTile();
    }
    
    public void moveTiles(String direction) {
        if (direction.equals("down")) {
            board.moveDown();
        } else if (direction.equals("right")) {
            board.moveRight();
        } else if (direction.equals("left")) {
            board.moveLeft();
        } else if (direction.equals("up")) {
            board.moveUp();
        }
        int roundScore = board.gridCountScoreAndResetMerge();
        if (roundScore == -1) { 
            this.gameOver = true;
        } else { 
            this.score += roundScore;
            board.addRandomTile();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
}
