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
public class Score {
    
    private String name;
    private int gridSize;
    private int score;
    
    public Score(String name, int gridSize, int score) {
        this.name = name;
        this.gridSize = gridSize;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getGridSize() {
        return this.gridSize;
    }
    
    public int getScore() {
        return this.score;
    }
    
}
