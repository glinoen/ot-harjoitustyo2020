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
public class Board {
    private int[][] grid;
    
    
    
    public Board(int boardSize) {
        this.grid = new int[boardSize][boardSize];
    }
}
