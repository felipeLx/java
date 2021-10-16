package org.bootcamp.cells;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.bootcamp.Direction;
import org.bootcamp.Grid;

public class Player {

    private Rectangle rectangle;
    private int col;
    private int row;

    public Player() {
        col = 1;
        row = 1;
        rectangle = new Rectangle( col* Grid.CELLSIZE, row*Grid.CELLSIZE,Grid.CELLSIZE,Grid.CELLSIZE);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
    }

    public void move(Direction direction){
        switch (direction){
            case UP:
                row--;
                rectangle.translate(0,-Grid.CELLSIZE);
                break;
            case DOWN:
                row++;
                rectangle.translate(0,Grid.CELLSIZE);
                break;
            case RIGHT:
                col++;
                rectangle.translate(Grid.CELLSIZE, 0 );
                break;
            case LEFT:
                col--;
                rectangle.translate(-Grid.CELLSIZE,0);
                break;
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
