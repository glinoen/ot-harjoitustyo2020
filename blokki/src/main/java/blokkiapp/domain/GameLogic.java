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
    private Board lauta;
    
    public GameLogic() {
        this.score = 0;
    }
    
    public void newGame(int size) {
        this.lauta = new Board(size);
        lauta.gridInit();
        lauta.addRandomTile();
        lauta.addRandomTile();
    }
    
    public void moveTiles(String direction) {
        if(direction.equals("down")) {
            lauta.moveDown();
        } else if (direction.equals("right")) {
            lauta.moveRight();
        } else if (direction.equals("left")) {
            lauta.moveLeft();
        } else if (direction.equals("up")) {
            lauta.moveUp();
        }
        lauta.addRandomTile();
        lauta.gridResetMerge();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Board getLauta() {
        return lauta;
    }

    public void setLauta(Board lauta) {
        this.lauta = lauta;
    }
    
}
