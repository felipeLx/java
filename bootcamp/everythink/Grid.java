package org.lxgames.painting2;

import org.lxgames.painting2.grid.Cell;

public class Grid {

    private int height;
    private int width;
    private Cell[][]cells;


    public static final int CELL_SIZE = 20;
    public static final int PADDING = 5;


    public Grid(int height, int width) {
        this.height = height;
        this.width = width;

        cells = new Cell[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }

    }

    public void stringToGrid(String grid){

        int index = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                Cell cell = cells[row][col];

                if(grid.charAt(index) == '0') {
                    cell.erase();
                } else {
                    cell.paint();
                }

                index++;
            }
            index++; // skip "\n" on each line
        }
    }

    public void clear(){

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                cells[row][col].erase();
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int row, int col){return cells[row][col];}


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                stringBuilder.append(cells[row][col]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
