/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author julinden
 */
public class GameLogicTest {
    GameLogic logic;
    
    @Before
    public void setUp() {
        logic = new GameLogic();
    }
    
    @Test
    public void newGameSetsBoardUpInRightWay() {
        logic.newGame(4);
        int gridvalue = 0;
        Tile[][] grid = logic.getBoard().getGrid();
        for (int i = 0; i < logic.getBoard().boardSize; i++) { 
            for (int j = 0; j < logic.getBoard().boardSize; j++) { 
                if (grid[i][j].getValue() > 0) { 
                    gridvalue++;
                }
            }
        }
        assertEquals(2, gridvalue);
    }
    
    @Test
    public void gameCanBeWon() {
        logic.newGame(4);
        Tile[][] grid = logic.getBoard().getGrid();
        grid[0][3].setValue(1024);
        grid[1][3].setValue(1024);
        logic.moveTiles("down");
        assertTrue(logic.isGameWon());
    }
    
    @Test
    public void gameIsLostWhenBoardIsFull() {
        logic.newGame(4);
        int gridvalue = 1;
        Tile[][] grid = logic.getBoard().getGrid();
        for (int i = 0; i < logic.getBoard().boardSize; i++) { 
            for (int j = 0; j < logic.getBoard().boardSize; j++) { 
                grid[i][j].setValue(gridvalue);
                gridvalue++;
            }
        }
        logic.moveTiles("up");
        assertTrue(logic.isGameOver());
    }
    
    @Test
    public void movingTilesDownWorks() {
        logic.newGame(4);
        Tile[][] grid = logic.getBoard().getGrid();
        grid[0][3].setValue(2);
        grid[1][3].setValue(2);
        grid[2][3].setValue(2);
        grid[3][3].setValue(2);
        logic.moveTiles("down");
        assertEquals(8, grid[2][3].getValue() + grid[3][3].getValue());
    }
    
    
    @Test
    public void movingTilesUpWorks() {
        logic.newGame(4);
        Tile[][] grid = logic.getBoard().getGrid();
        grid[0][3].setValue(2);
        grid[1][3].setValue(2);
        grid[2][3].setValue(2);
        grid[3][3].setValue(2);
        logic.moveTiles("up");
        assertEquals(8, grid[0][3].getValue() + grid[1][3].getValue());
    }
    
    @Test
    public void movingTilesRightWorks() {
        logic.newGame(4);
        Tile[][] grid = logic.getBoard().getGrid();
        grid[0][0].setValue(2);
        grid[0][1].setValue(2);
        grid[0][2].setValue(2);
        grid[0][3].setValue(2);
        logic.moveTiles("right");
        assertEquals(8, grid[0][2].getValue() + grid[0][3].getValue());
    }
    
    @Test
    public void movingTilesLeftWorks() {
        logic.newGame(4);
        Tile[][] grid = logic.getBoard().getGrid();
        grid[0][0].setValue(2);
        grid[0][1].setValue(2);
        grid[0][2].setValue(2);
        grid[0][3].setValue(2);
        logic.moveTiles("left");
        assertEquals(8, grid[0][0].getValue() + grid[0][1].getValue());
    }

}
