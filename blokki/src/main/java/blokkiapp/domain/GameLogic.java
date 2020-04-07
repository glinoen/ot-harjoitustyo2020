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
    
    public GameLogic() {
        this.score = 0;
    }
    
    public void newGame(int size) {
        this.board = new Board(size);
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
        board.addRandomTile();
        board.gridResetMerge();
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
