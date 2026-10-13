package io.github.itsxenon06.vixualizr.core.grid;

public class Grid {
    private final int rows;
    private final int cols;
    private final boolean[][] walls;

    public Grid(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive integers.");
        }
        this.rows = rows;
        this.cols = cols;
        walls = new boolean[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setWall(int row, int col, boolean wall) {
        if (!inBounds(row, col)) {
            throw new IllegalArgumentException("Row or column is out of bounds.");
        }
        walls[row][col] = wall;
    }

    public boolean isWall(int row, int col) {
        if(!inBounds(row, col)) {
            throw new IllegalArgumentException("Row or column is out of bounds.");
        }
        return walls[row][col];
    }

    public int toNode(int row, int col) {
        if(!inBounds(row, col)) {
            throw new IllegalArgumentException("Row or column is out of bounds.");
        }
        return row * cols + col;
    }

    public int toRow(int node) {
        if(node < 0 || node >= rows * cols) {
            throw new IllegalArgumentException("Node is out of bounds.");
        }
        return node / cols;
    }

    public int toCol(int node) {
        if(node < 0 || node >= rows * cols) {
            throw new IllegalArgumentException("Node is out of bounds.");
        }
        return node % cols;
    }

    public boolean inBounds(int row, int col) {
        return 0 <= row && row < rows && 0 <= col && col < cols;
    }
}


