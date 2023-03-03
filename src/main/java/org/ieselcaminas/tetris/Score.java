/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ieselcaminas.tetris;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author victor
 */
public class Score implements Comparable<Score>, Serializable {
    
    private String name;
    private int score;
    private Calendar date;
    private int level;


    public Score(String name, int score, Calendar date, int level) {
        this.name = name;
        this.score = score;
        this.date = date;
        this.level = level;
    }
    
    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
    
    @Override
    pubic String toString() {
        return name + ": " + score + ": " + date + ": " + level;
    }
 
    
    @Override
    public int compareTo(Score t) {
       Integer i = score;
       Integer i2 = t.score;
       return i.compareTo(i2);
    }
    
}
