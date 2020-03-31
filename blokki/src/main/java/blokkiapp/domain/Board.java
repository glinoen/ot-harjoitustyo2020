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
import java.util.*;

public class Board {
    public final int BOARD_SIZE;
    public final int LOWEST_NUMBER;
    public final int STARTING_TILES;
    
    private int[][] grid;
    
    
    
    public Board(int boardSize, int lowestNumber, int startingTiles) {
        this.BOARD_SIZE = boardSize;
        this.LOWEST_NUMBER = lowestNumber;
        this.STARTING_TILES = startingTiles;
        this.grid = new int[boardSize][boardSize];
    }
    
    public Board() {
        this(4,2,2);
    }
    
    public Board(int boardSize) {
        this(boardSize,2,2);
    }
}
