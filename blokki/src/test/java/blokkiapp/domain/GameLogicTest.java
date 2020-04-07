/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

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

}
