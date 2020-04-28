/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

/**
 *
 * Methods for saving score data
 */
public class Score {
    
    private String name;
    private int gridSize;
    private int score;
    
    /**
     * Constructor for a score
     * @param name the name of the scorer
     * @param gridSize the size of the grid where the score was made
     * @param score the numerical value of the score
     */
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
