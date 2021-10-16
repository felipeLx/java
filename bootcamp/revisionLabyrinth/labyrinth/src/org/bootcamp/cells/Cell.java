package org.bootcamp.cells;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.bootcamp.Grid;

public class Cell {

    private Rectangle rectangle;
    private boolean wall;


    public Cell(int row, int col){
        rectangle = new Rectangle( col* Grid.CELLSIZE, row*Grid.CELLSIZE,Grid.CELLSIZE,Grid.CELLSIZE);
        rectangle.draw();
    }


    public void becomeWall() {
        wall = true;
        rectangle.fill();
    }

    public boolean isWall() {
        return wall;
    }
}
