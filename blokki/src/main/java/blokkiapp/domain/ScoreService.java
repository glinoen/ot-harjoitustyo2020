/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

import blokkiapp.dao.ScoreDao;
import java.util.ArrayList;

/**
 *
 * @author julinden
 */
public class ScoreService {
    private ScoreDao scoreDao;
    
    public ScoreService(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }
    
    public boolean createScore(Score score) {
        try {
            scoreDao.create(score);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public ArrayList<Score> getScores(int gridSize) {
        return scoreDao.getScoresForGrid(gridSize);
    }
}
