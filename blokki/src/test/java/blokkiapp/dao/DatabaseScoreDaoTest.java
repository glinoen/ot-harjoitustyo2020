/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.dao;

import blokkiapp.domain.Score;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julinden
 */
public class DatabaseScoreDaoTest {
    private static DatabaseScoreDao databaseScoreDao;
    
    @BeforeClass
    public static void beforeClass() {
        databaseScoreDao = new DatabaseScoreDao("test.db");
        databaseScoreDao.clear();
    }
    
    @After
    public void tearDown() { 
        databaseScoreDao.clear();
    }
    
    @Test
    public void listIsEmptyWhenDbIsEmpty() { 
        assertEquals(true, databaseScoreDao.getScoresForGrid(4).isEmpty());
    }
    
    @Test
    public void clearMethodWorks() { 
        databaseScoreDao.create(new Score("hessu", 4, 512));
        databaseScoreDao.clear();
        assertEquals(true, databaseScoreDao.getScoresForGrid(4).isEmpty());
    }
    
    @Test
    public void scoreCreationWorks() { 
        databaseScoreDao.create(new Score("testeri", 4, 1024));
        assertEquals("testeri", databaseScoreDao.getScoresForGrid(4).get(0).getName());
    }
    
    @Test
    public void scoreFilteringWorks() { 
        databaseScoreDao.create(new Score("sickboy", 4, 600));
        databaseScoreDao.create(new Score("wää", 5, 600));
        assertEquals(1, databaseScoreDao.getScoresForGrid(4).size());
    }
    
    @Test
    public void scoresAreInRightOrder() { 
        databaseScoreDao.create(new Score("sickboy", 4, 600));
        databaseScoreDao.create(new Score("wää", 4, 800));
        databaseScoreDao.create(new Score("bää", 4, 1800));
        databaseScoreDao.create(new Score("doom", 4, 400));
        assertEquals("bää", databaseScoreDao.getScoresForGrid(4).get(0).getName());
    }
}
