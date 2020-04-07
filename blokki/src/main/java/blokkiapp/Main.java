/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp;

import blokkiapp.domain.Board;
import blokkiapp.domain.GameLogic;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author julinden
 */
public class Main {
    public static void main(String[] args) {
        int[][] omalauta = new int[4][4];
        omalauta[0][0] = 2;
        omalauta[0][1] = 2;
        omalauta[0][2] = 0;
        omalauta[0][3] = 2;
        
        GameLogic logiik = new GameLogic();
        logiik.newGame(5);
        logiik.getLauta().printGrid();
        logiik.moveTiles("right");
        logiik.getLauta().printGrid();
        
        Scanner lukija = new Scanner(System.in);
        while (true) {
            String rivi = lukija.nextLine();

            if (rivi.equals("end")) {
                break;
            }else if(rivi.equals("w")) {
                logiik.moveTiles("up");
            }else if(rivi.equals("a")) {
                logiik.moveTiles("left");
            }else if(rivi.equals("s")) {
                logiik.moveTiles("down");
            }else if(rivi.equals("d")) {
                logiik.moveTiles("right");
            }
            logiik.getLauta().printGrid();
            // lisää luettu rivi listalle myöhempää käsittelyä
            // varten tai käsittele rivi heti

        }
        

//        lauta.moveDown();
//        System.out.println("moveDown");
//        lauta.printGrid();
//        
//        lauta.addRandomTile();
//        System.out.println("tilez");
//        lauta.printGrid();
//        
//        lauta.moveUp();
//        System.out.println("moveUp");
//        lauta.printGrid();
//        
//        lauta.addRandomTile();
//        System.out.println("tilez");
//        lauta.printGrid();
//        
//        lauta.moveDown();
//        System.out.println("moveDown");
//        lauta.printGrid();
//        
//        lauta.addRandomTile();
//        System.out.println("tilez");
//        lauta.printGrid();
//        
//        lauta.moveUp();
//        System.out.println("moveUp");
//        lauta.printGrid();
//        
//        lauta.addRandomTile();
//        System.out.println("tilez");
//        lauta.printGrid();
//        
//        lauta.moveDown();
//        System.out.println("moveDown");
//        lauta.printGrid();
//        
//        lauta.addRandomTile();
//        System.out.println("tilez");
//        lauta.printGrid();
//        
//        lauta.moveUp();
//        System.out.println("moveUp");
//        lauta.printGrid();
//        
//        lauta.addRandomTile();
//        System.out.println("tilez");
//        lauta.printGrid();
        
        
    }
}
