/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author julinden
 */
public class BoardTest {
    Board board;
    
    @Before
    public void setUp() {
        board = new Board(4);
    }
    
    @Test
    public void boardExists() {
        assertTrue(board!=null);      
    }
    
    @Test
    public void boardHasTheRightGridSize() {
        assertEquals(4, board.getGrid().length);
    }
    
    @Test
    public void gridInitalizationWorks() {
        int gridvalue = 0;
        board.gridInit();
        Tile[][] grid = board.getGrid();
        for (int i = 0; i < board.boardSize; i++) { 
            for (int j = 0; j < board.boardSize; j++) { 
                gridvalue += grid[i][j].getValue();
            }
        }
        assertEquals(0, gridvalue);
    }
    
    @Test
    public void addingOfRandomTileAddsATile() { 
        int gridvalue = 0;
        board.gridInit();
        board.addRandomTile();
        Tile[][] grid = board.getGrid();
        for (int i = 0; i < board.boardSize; i++) { 
            for (int j = 0; j < board.boardSize; j++) { 
                if (grid[i][j].getValue() > 0) { 
                    gridvalue++;
                }
            }
        }
        assertEquals(1, gridvalue);
    }
}
