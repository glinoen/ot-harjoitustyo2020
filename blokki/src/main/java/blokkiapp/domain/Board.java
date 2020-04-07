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
    public final int boardSize;
    public final int lowestNumber;
    public final int startingTiles;
    
    private Tile[][] grid;
    
    private Random random = new Random();
    
    public Board(int boardSize, int lowestNumber, int startingTiles) {
        this.boardSize = boardSize;
        this.lowestNumber = lowestNumber;
        this.startingTiles = startingTiles;
        this.grid = new Tile[boardSize][boardSize];
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
    
    public void gridInit() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                grid[i][j] = new Tile(i, j);
            }
        }
    }
    
    public void gridResetMerge() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                grid[i][j].setMerged(false);
            }
        }
    }
    
    public void addRandomTile() {
        while (true) {
            int randomX = random.nextInt(boardSize);
            int randomY = random.nextInt(boardSize);
            if (grid[randomX][randomY].getValue() == 0) {
                int tmp = random.nextInt(2) + 1;
                grid[randomX][randomY].setValue(tmp * lowestNumber);
                break;
            }
        }
    }
    
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
    


    public  void printGrid() {
        Arrays.stream(grid)
            .forEach(
                (row) -> {
                    System.out.print("[");
                    Arrays.stream(row)
                        .forEach((tile) -> System.out.print(" " + tile.getValue() + " "));
                    System.out.println("]");
                }
            );
        System.out.println("");
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }
    
    


    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    
    
}
