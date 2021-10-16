package org.lxgames.myPaint.grid;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.lxgames.myPaint.Grid;

public class ColorCell {

    int row;
    int col;
    Ellipse ellipse;
    private boolean selected;
    private static final int CELL_SIZE = 20;


    public ColorCell(int row, int col) {
        this.row = row;
        this.col = col;

        ellipse = new Ellipse(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE + Grid.PADDING, CELL_SIZE);
        ellipse.draw();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isSelected() {
        return selected = true;
    }
}
