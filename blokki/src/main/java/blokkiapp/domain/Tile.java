/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

/**
 * Class which represents one tile in the grid
 */
public class Tile {
    private int value;
    private boolean merged;
    
    public Tile() {
        this.value = 0;
        this.merged = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }
    
    
}
