package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(1000,  kortti.saldo());
    }
    
    @Test
    public void saldonLatausToimii() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0",  kortti.toString());
    }
    
    @Test
    public void rahanOtto() {
        kortti.otaRahaa(500); 
        assertEquals("saldo: 5.0",  kortti.toString());
    }
    
    @Test
    public void rahanOttoIlmanRahaa() {
        kortti.otaRahaa(1500); 
        assertEquals("saldo: 10.0",  kortti.toString());
    }
    
    @Test
    public void eiTarpeeksiRahaaMetodi() {
        assertTrue(!kortti.otaRahaa(1500));      
    }
    
    @Test
    public void tarpeeksiRahaaMetodi() {
        assertTrue(kortti.otaRahaa(1000));      
    }
}
