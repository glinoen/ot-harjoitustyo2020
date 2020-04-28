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

/**
 * Functionality of the grid
 */
public class Board {
    public final int boardSize;
    public final int lowestNumber;
    public final int startingTiles;
    private boolean gameWon;
    
    private Tile[][] grid;
    
    private Random random = new Random();
    
    /**
     * Constructor, sets the settings of the game
     * @param boardSize the size of the grid
     * @param lowestNumber the starting value
     * @param startingTiles the amount of tiles in the beginning
     */
    public Board(int boardSize, int lowestNumber, int startingTiles) {
        this.boardSize = boardSize;
        this.lowestNumber = lowestNumber;
        this.startingTiles = startingTiles;
        this.grid = new Tile[boardSize][boardSize];
        this.gameWon = false;
    }
    
    public Board() {
        this(4, 2, 2);
    }
    
    public Board(int boardSize) {
        this(boardSize, 2, 2);
    }
    
    public Board(int boardSize, int lowestNumber) {
        this(boardSize, lowestNumber, 2);
    }
    
    /**
     * Method for initializing the grid or clearing the grid
     */
    public void gridInit() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                grid[i][j] = new Tile();
            }
        }
    }
    
    /**
     * Method which counts score after a move, and resets the merge value of moved tiles
     * @return the score of the turn or -1 if the board is full
     */
    public int gridCountScoreAndResetMerge() {
        boolean full = true;
        int score = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Tile currentTile = grid[i][j];
                if (currentTile.getValue() == 2048) { 
                    this.gameWon = true;
                }
                if (currentTile.getValue() == 0) {
                    full = false;
                }
                if (currentTile.isMerged()) {
                    score += currentTile.getValue();
                    currentTile.setMerged(false);
                }
            }
        }
        if (full) { 
            return -1;
        } else { 
            return score;
        }
    }
    
    /**
     * Method for adding a random tile to the grid
     */
    public void addRandomTile() {
        while (true) {
            int randomX = random.nextInt(boardSize);
            int randomY = random.nextInt(boardSize);
            if (grid[randomX][randomY].getValue() == 0) {
                int tmp = random.nextInt(5) + 1;
                if (tmp == 1) {
                    tmp = 2;
                } else { 
                    tmp = 1;
                }
                grid[randomX][randomY].setValue(tmp * lowestNumber);
                break;
            }
        }
    }
    
    /**
     * Moves or merges tiles depending on the situation
     * @param s tells the method if it should move or merge
     * @param tile another of the tiles being compared
     * @param comparedTile another of the tiles being compared
     */
    public void tileMoverOrMerger(int s, Tile tile, Tile comparedTile) {
        if (s % 2 != 0 && comparedTile.getValue() == 0) {
            comparedTile.setValue(tile.getValue());
            tile.setValue(0);
        } else if (s % 2 == 0 && tile.getValue() == comparedTile.getValue() && !comparedTile.isMerged() && !tile.isMerged()) {
            comparedTile.setValue(tile.getValue() * 2);
            comparedTile.setMerged(true);
            tile.setValue(0);
        }
    }
    
    /**
     * Method for moving the tiles down
     */
    public void moveDown() {
        for (int s = 1; s < 4; s++) {
            for (int b = boardSize - 2; b >= 0; b--) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = b; j < boardSize; j++) {
                        Tile tile = grid[j][i];
                        if (tile.getValue() == 0) {
                            ;
                        } else {
                            if (j + 1 < boardSize) {
                                Tile comparedTile = grid[j + 1][i];
                                tileMoverOrMerger(s, tile, comparedTile);
                            }
                        }
                    }
                }
            }
        } 
    }
    /**
     * Method for moving the tiles right
     */
    public void moveRight() {
        for (int s = 1; s < 4; s++) {
            for (int b = boardSize - 2; b >= 0; b--) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = b; j < boardSize; j++) {
                        Tile tile = grid[i][j];
                        if (tile.getValue() == 0) {
                            ;
                        } else {
                            if (j + 1 < boardSize) {
                                Tile comparedTile = grid[i][j + 1];
                                tileMoverOrMerger(s, tile, comparedTile);
                            }
                        }
                    }
                }
            }
        } 
    }
    
    /**
     * Method for moving the tiles up
     */
    public void moveUp() {
        for (int s = 1; s < 4; s++) {
            for (int b = 1; b < boardSize; b++) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = b; j >= 0; j--) {
                        Tile tile = grid[j][i];
                        if (tile.getValue() == 0) {
                            ;
                        } else {
                            if (j - 1 >= 0) {
                                Tile comparedTile = grid[j - 1][i];
                                tileMoverOrMerger(s, tile, comparedTile);
                            }
                        }
                    }
                }
            }
        }    
    }
    
    /**
     * Method for moving the tiles left
     */
    public void moveLeft() {
        for (int s = 1; s < 4; s++) {
            for (int b = 1; b < boardSize; b++) {
                for (int i = 0; i < boardSize; i++) {
                    for (int j = b; j >= 0; j--) {
                        Tile tile = grid[i][j];
                        if (tile.getValue() == 0) {
                            ;
                        } else {
                            if (j - 1 >= 0) {
                                Tile comparedTile = grid[i][j - 1];
                                tileMoverOrMerger(s, tile, comparedTile);
                            }
                        }
                    }
                }
            }
        }    
    }
    
    /**
     * Method for getting the 2D grid
     * @return the grid containing the current state of the game
     */
    public Tile[][] getGrid() {
        return grid;
    }
    
    /**
     * Method which tells if the game has been won
     * @return true if game is won
     */
    public boolean isGameWon() {
        return this.gameWon;
    }

    
}
