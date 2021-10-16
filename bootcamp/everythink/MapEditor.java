package org.lxgames.painting2;

import org.lxgames.painting2.grid.*;
import org.lxgames.painting2.util.*;
import java.io.IOException;

public class MapEditor {

    private Cursor cursor;
    private Grid grid;
    private ColorBar colorBar;
    private boolean painting;

    public MapEditor (int height, int width) {
        cursor = new Cursor();
        grid = new Grid(height, width);
        colorBar = new ColorBar(height/2, width/4);

    }

    public void moveCursor(Cursor.Direction direction) {

        if(cursorOnEdge(direction)) {
            return;
        }

        switch (direction) {
            case UP:
                cursor.moveUp();
                break;
            case DOWN:
                cursor.moveDown();
                break;
            case LEFT:
                cursor.moveLeft();
                break;
            case RIGHT:
                cursor.moveRight();
                break;
        }

        if(painting){
            paintCell();
        }
    }

    public boolean cursorOnEdge(Cursor.Direction direction) {

        return direction == Cursor.Direction.UP && cursor.getRow() == 0 ||
                direction == Cursor.Direction.DOWN && cursor.getRow() == grid.getHeight() -1 ||
                direction == Cursor.Direction.LEFT && cursor.getCol() == 0 ||
                direction == Cursor.Direction.RIGHT && cursor.getCol() == grid.getWidth() -1;

    }

    public void paintCell() {

        Cell cell = grid.getCell(cursor.getRow(),cursor.getCol());
        if (cell.isPainted()) {
            cell.erase();
        } else {
            cell.paint();
        }
    }

    public void drawColorBar(){
        Cell cell = colorBar.getCell(colorBar.getBarRow(), colorBar.getBarCol());
        cell.paint();
    }

    public void clear(){grid.clear(); }

     public void load() throws IOException {
        grid.stringToGrid(FileManager.readFile());
    }
    public void save() throws IOException {
        FileManager.writeToFile(grid.toString());
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }


}
