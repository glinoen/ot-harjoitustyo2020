/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.domain;

import blokkiapp.dao.ScoreDao;
import java.util.ArrayList;

/**
 * Class responsible for interacting with DAO
 */
public class ScoreService {
    private ScoreDao scoreDao;
    
    
    public ScoreService(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }
    
    /**
     * Method for adding a new score
     * @param score the score being added
     * @return true if successful
     */
    public boolean createScore(Score score) {
        try {
            scoreDao.create(score);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Method for getting a list of scores
     * @param gridSize the grid size of preferred scores
     * @return the list of scores for a grid size value
     */
    public ArrayList<Score> getScores(int gridSize) {
        return scoreDao.getScoresForGrid(gridSize);
    }
}
