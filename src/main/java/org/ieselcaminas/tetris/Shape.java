/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ieselcaminas.tetris;

/**
 *
 * @author victor
 */
public class Shape {

    private static final int[][][] COORDS_TABLE = new int[][][]{
        {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
        {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
        {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
        {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
        {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
        {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
        {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
        {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
    };
    
    private Tetrominoes pieceShape;
    private int coords[][]; 
    
    public Shape() {
        coords = new int[4][2];
        setRandomShape();
    }
    
    public void setShape(Tetrominoes shapeType) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                coords[i][j] = COORDS_TABLE[shapeType.ordinal()][i][j];
            }
        }
        pieceShape = shapeType;
    }
    
    public void setX(int index, int x) {
        coords[index][0] = x;
    }
    public void setY(int index, int y) {
        coords[index][1] = y;
    }
    
    public int getX(int index) {
        return coords[index][0];
    }
    public int getY(int index) {
        return coords[index][1];
    }
    public void setRandomShape() {
        int random = (int)(Math.random() * 7 ) + 1;
        Tetrominoes tetro = Tetrominoes.values()[random];
        setShape(tetro);
    }
    
    public int minX() {
        int min = coords[0][0];
        for (int i = 1; i < 4; i++) {
            if (coords[i][0] < min) {
                min = coords[i][0];
            }
        }
        return min;
    }
    
    public int maxX() {
        int max = coords[0][0];
        for (int i = 1; i < 4; i++) {
            if (coords[i][0] > max) {
                max = coords[i][0];
            }
        }
        return max;
    }
    
    public int minY() {
        int min = coords[0][1];
        for (int i = 1; i < 4; i++) {
            if (coords[i][1] < min) {
                min = coords[i][4];
            }
        }
        return min;
    }
    
    public int maxY() {
        int max = coords[0][1];
        for (int i = 1; i < 4; i++) {
            if (coords[i][1] > max) {
                max = coords[i][1];
            }
        }
        return max;
    }
    
    public Shape rotateLeft() {
        Shape newShape = new Shape();
        newShape.setShape(pieceShape);
        if (pieceShape != Tetrominoes.SquareShape) {
            for (int i = 0; i < 4; i++) {
                newShape.setX(i, getY(i));
                newShape.setY(i, -getX(i));
            }
        }
        return newShape;
    }
      
    public Tetrominoes getShape() {
        return pieceShape;
    }
            
}
