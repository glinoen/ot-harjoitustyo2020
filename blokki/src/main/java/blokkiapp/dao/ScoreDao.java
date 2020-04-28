/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.dao;

import blokkiapp.domain.Score;
import java.util.ArrayList;

/**
 *
 * @author julinden
 */
public interface ScoreDao {
    
    Boolean create(Score score) throws Exception;
    ArrayList<Score> getScoresForGrid(int gridSize);
    
}
