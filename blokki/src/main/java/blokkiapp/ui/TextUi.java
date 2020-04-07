/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.ui;

import blokkiapp.domain.GameLogic;
import java.util.Scanner;

/**
 *
 * @author julinden
 */
public class TextUi {
    private Scanner reader;
    private GameLogic logic;
    
    public TextUi(Scanner reader) {
        this.reader = reader;
        logic = new GameLogic();
        
    }
    
    public void start() {
        logic.newGame(4);
        logic.getLauta().printGrid();
        System.out.println("wasd+enter to move grid, type end to quit");
        while (true) {
            String row = reader.nextLine();
            if (row.equals("end")) {
                break;
            } else if (row.equals("w")) { 
                logic.moveTiles("up");
            } else if (row.equals("a")) { 
                logic.moveTiles("left");
            } else if (row.equals("s")) { 
                logic.moveTiles("down");
            } else if (row.equals("d")) { 
                logic.moveTiles("right");
            }
            logic.getLauta().printGrid();
        }  
    }
}
