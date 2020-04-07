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
public class Tile {
    private int value;
    private int locationX;
    private int locationY;
    private boolean merged;
    
    public Tile(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.value = 0;
        this.merged = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }
    
    
}
