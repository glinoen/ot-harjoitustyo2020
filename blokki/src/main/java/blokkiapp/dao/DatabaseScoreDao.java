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
 * Database functionality of the program
 */
public class DatabaseScoreDao implements ScoreDao {
    
    private String dbName;
    private Connection connection;
    private Statement statement;
    private PreparedStatement pStatement;
    
    /**
     * Constructor
     */
    public DatabaseScoreDao(String name) {
        this.dbName = name;
        initDb();
    }
    
    /**
     * Method for initializing the database
     */
    public void initDb() {
        try {
            startDbConnection();
            statement.execute("CREATE TABLE IF NOT EXISTS Scores (id INTEGER PRIMARY KEY, name TEXT NOT NULL, gridsize INTEGER, score INTEGER);");
            closeDbConnection();
        } catch (SQLException e) {
            
        }
    }
    
    /**
     * Method which tries to make a connection to the database
     */
    public void startDbConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbName);
            statement = connection.createStatement();
        } catch (SQLException e) {
            
        }
    }
    
    /**
     * Method which tries to close the connection to the database
     */
    public void closeDbConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            
        }
    }
    
    /**
     * Method which stores a score to the database
     * 
     * @param score The score which is saved to the database
     * 
     * @return true if everything was successful
     */
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
    
    /**
     * Method which gets a list of scores from the database
     * 
     * @param gridSize Returns scores for this grid size.
     * 
     * @return a list of scores
     */
    @Override
    public ArrayList<Score> getScoresForGrid(int gridSize) {
        try {
            startDbConnection();
            pStatement = connection.prepareStatement("SELECT name, score, gridsize FROM Scores WHERE gridsize=? ORDER BY score DESC;");
            pStatement.setInt(1, gridSize);
            ResultSet scores = pStatement.executeQuery();
            
            ArrayList<Score> scoreList = new ArrayList<>();
            
            while (scores.next()) { 
                scoreList.add(new Score(scores.getString("name"), scores.getInt("gridsize"), scores.getInt("score")));
            }
            pStatement.close();
            closeDbConnection();
            return scoreList;
        
        } catch (SQLException e) {
            return null;
        }
    }
    
    /**
     * Method which removes all data from database
     */
    @Override
    public void clear() {
        try { 
            startDbConnection();
            statement.execute("DROP TABLE IF EXISTS Scores;");
            closeDbConnection();
            initDb();
        } catch (SQLException e) { 
            
        }
        
    }
}
