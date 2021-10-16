package org.lxgames.painting2;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.lxgames.painting2.grid.Cell;

import static org.lxgames.painting2.Grid.CELL_SIZE;
import static org.lxgames.painting2.Grid.CELL_SIZE;
import static org.lxgames.painting2.Grid.PADDING;



public class ColorBar {

    private int barRow;
    private int barCol;
    private Cell[][] colorBar;

    public ColorBar(int barRow, int barCol) {
        this.barRow = 10;
        this.barCol = 20;

        colorBar = new Cell[barRow][barCol];

        for (int row = 0; row < barRow; row++) {
            for (int col = 0; col < barCol; col++) {
                colorBar[row][col] = new Cell(row,col);
            }
        }

        Rectangle rectangle = new Rectangle(PADDING + 10, PADDING + 10, getBarRow(), getBarCol());
        rectangle.draw();
    }

    public int getBarRow() {
        return barRow;
    }

    public int getBarCol() {
        return barCol;
    }

    public Cell getCell(int row, int col) {
        return colorBar[row][col];
    }
}
