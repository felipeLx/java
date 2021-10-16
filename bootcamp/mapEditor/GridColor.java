package org.lxgames.myPaint;

import org.lxgames.myPaint.grid.ColorCell;

public class GridColor {

    public static final int CELL_SICE = 30;
    private int rows;
    private int cols;

    private ColorCell[][]colorCells;


    public GridColor(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        colorCells = new ColorCell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < 2; col++) {
                colorCells[row][col] = new ColorCell(row,col);
            }
        }
    }
}
