/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

/**
 * Methods for controlling the flow of the game
 */
public class GameLogic {
    private int score;
    private Board board;
    private boolean gameOver;
    private boolean gameWon;
    
    public GameLogic() {
        
    }
    /**
     * Tells if the game is over
     * @return true if game is over
     */
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Tells if the game is won
     * @return true if the game is won
     */
    public boolean isGameWon() {
        return gameWon;
    }
    
    /**
     * Method for setting up a new game according to the rules
     * @param size the size of the game grid
     */
    public void newGame(int size) {
        this.board = new Board(size);
        this.gameOver = false;
        this.gameWon = false;
        this.score = 0;
        board.gridInit();
        board.addRandomTile();
        board.addRandomTile();
    }
    
    /**
     * Method for executing a move the impact of the move
     * @param direction which direction the tiles are moved
     */
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
            if (board.isGameWon() ) {
                this.gameWon = true;
            } else { 
                board.addRandomTile();
            }
        }
    }
    
    /**
     * Method for getting the current score
     * @return the current score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Method for getting the board, so one can get access to grid info
     * @return the board which contains the grid
     */
    public Board getBoard() {
        return board;
    }

}
