package org.lxgames.myPaint.grid;


import org.academiadecodigo.simplegraphics.graphics.*;
import static org.lxgames.myPaint.Grid.CELL_SIZE;
import static org.lxgames.myPaint.Grid.PADDING;

public class Cell {

    int row;
    int col;
    Rectangle rectangle;
    private boolean painted;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        rectangle = new Rectangle(col * CELL_SIZE + PADDING, row * CELL_SIZE + PADDING, CELL_SIZE, CELL_SIZE );
        rectangle.draw();

    }

    public void paint() {
        painted = true;
        rectangle.fill();
    }

    public void erase(){
        painted = false;
        rectangle.draw();
    }

    @Override
    public String toString() {
        return painted ? "1" : "0";
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isPainted() {
        return painted;
    }
}
