/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp;

import blokkiapp.domain.Board;
import blokkiapp.domain.GameLogic;
import blokkiapp.ui.TextUi;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author julinden
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        TextUi textUi = new TextUi(reader);
        textUi.start();
    }
}
