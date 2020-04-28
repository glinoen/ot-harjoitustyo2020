/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokkiapp.dao;

import blokkiapp.domain.Score;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author julinden
 */
public class DatabaseScoreDao implements ScoreDao {
    
    private String dbName;
    private Connection connection;
    private Statement statement;
    private PreparedStatement pStatement;
    
    public DatabaseScoreDao() {
        this.dbName = "scores";
        initDb();
    }
    
    public void initDb() {
        try {
            startDbConnection();
            statement.execute("CREATE TABLE IF NOT EXISTS Scores (id INTEGER PRIMARY KEY, name TEXT NOT NULL, gridsize INTEGER, score INTEGER);");
            closeDbConnection();
        } catch (SQLException e) {
            
        }
    }
    
    public void startDbConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:scores");
            statement = connection.createStatement();
        } catch (SQLException e) {
            
        }
    }
    
    public void closeDbConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            
        }
    }
    
    @Override
    public Boolean create(Score score) {
        try {
            startDbConnection();
            pStatement = connection.prepareStatement("INSERT INTO Scores (name, gridsize, score) VALUES (?,?,?);");
            pStatement.setString(1, score.getName());
            pStatement.setInt(2, score.getGridSize());
            pStatement.setInt(3, score.getScore());
            pStatement.executeUpdate();
            pStatement.close();
            closeDbConnection();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    @Override
    public ArrayList<Score> getScoresForGrid(int gridSize) {
        try {
            startDbConnection();
            pStatement = connection.prepareStatement("SELECT name, score, gridsize FROM Scores WHERE gridsize=? ORDER BY score DESC;");
            pStatement.setInt(1, gridSize);
            ResultSet scores = pStatement.executeQuery();
            
            ArrayList<Score> scoreList = new ArrayList<>();
            
            while(scores.next()) {
                scoreList.add(new Score(scores.getString("name"), scores.getInt("gridsize"), scores.getInt("score")));
            }
            pStatement.close();
            closeDbConnection();
            return scoreList;
        
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
