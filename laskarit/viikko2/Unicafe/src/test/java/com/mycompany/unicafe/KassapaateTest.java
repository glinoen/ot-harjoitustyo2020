/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julinden
 */
public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void alkuOk() {
        assertTrue(kassapaate.kassassaRahaa() == 100000 && kassapaate.edullisiaLounaitaMyyty() == 0 && kassapaate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kateisOstoEdullinen() {
        int vaihtorahat = kassapaate.syoEdullisesti(500);
        assertTrue(kassapaate.kassassaRahaa() == 100240 && kassapaate.edullisiaLounaitaMyyty() == 1 && vaihtorahat == 260); 
    }
    
    @Test
    public void kateisOstoMaukas() {
        int vaihtorahat = kassapaate.syoMaukkaasti(500);
        assertTrue(kassapaate.kassassaRahaa() == 100400 && kassapaate.maukkaitaLounaitaMyyty() == 1 && vaihtorahat == 100); 
    }
    
    @Test
    public void kateisOstoEiRahaa() {
        int vaihtorahatE = kassapaate.syoEdullisesti(100);
        int vaihtorahatM = kassapaate.syoMaukkaasti(100);
        assertTrue(kassapaate.kassassaRahaa() == 100000 && kassapaate.edullisiaLounaitaMyyty() == 0 && kassapaate.maukkaitaLounaitaMyyty() == 0 && vaihtorahatE == 100 && vaihtorahatM == 100);
    }
    
    @Test
    public void korttiOstoEdullinen() {
        boolean onnistuuko = kassapaate.syoEdullisesti(kortti);
        assertTrue(kassapaate.edullisiaLounaitaMyyty() == 1 && onnistuuko); 
    }
    
    @Test
    public void korttiOstoMaukas() {
        boolean onnistuuko = kassapaate.syoMaukkaasti(kortti);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 1 && onnistuuko); 
    }
    
    @Test
    public void vahanRahaa() {
        Maksukortti koyhaKortti = new Maksukortti(100);
        int saldo = koyhaKortti.saldo();
        boolean syokoyhasti = kassapaate.syoEdullisesti(koyhaKortti);
        syokoyhasti = kassapaate.syoMaukkaasti(koyhaKortti);
        assertTrue(kassapaate.maukkaitaLounaitaMyyty() == 0 && kassapaate.edullisiaLounaitaMyyty() == 0 && saldo == koyhaKortti.saldo() && kassapaate.kassassaRahaa() == 100000 && !syokoyhasti); 
    }
    
    @Test
    public void rahanLataus() {
        int saldo = kassapaate.kassassaRahaa();
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertTrue(kortti.saldo() == 2000 && saldo + 1000 == kassapaate.kassassaRahaa());
    }
    
    @Test
    public void negatiivinenLataus() {
        kassapaate.lataaRahaaKortille(kortti, -1);
        assertTrue(kortti.saldo() == 1000 && 100000 == kassapaate.kassassaRahaa());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
