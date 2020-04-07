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
}
