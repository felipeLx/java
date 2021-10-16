package org.lxgames.myPaint;

import org.lxgames.myPaint.grid.*;
import org.lxgames.myPaint.utils.FileManager;

public class MapEditor {

    private Grid grid;
    private GridColor gridColor;
    private Cursor cursor;
    private boolean painting;
    private boolean selecting;

    public MapEditor(int rows, int cols) {

        grid = new Grid(rows, cols);
        gridColor = new GridColor(rows,2);
        cursor = new Cursor();
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

        if(painting) {
            paintCell();
        }
    }

    public void paintCell() {
        Cell cell = grid.getCell(cursor.getRow(), cursor.getCol());
        if(cell.isPainted()) {
            cell.erase();
        } else {
            cell.paint();
        }
    }

    public void selectColor() {
        ColorCell colorCell = grid.getCell(cursor.getRow(), cursor.getCol());
        if(colorCell.isSelected()) {
            setSelecting(true);
        }

    }
    public void clear() {
        grid.clear();
    }

    public void load() {
        grid.stringToGrid(FileManager.readFile());
    }

    public void save() {
        FileManager.writeToFile(grid.toString());
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    public void setSelecting(boolean selecting) {
        this.selecting = selecting;
    }

    private boolean cursorOnEdge(Cursor.Direction direction) {
        return direction == Cursor.Direction.UP && cursor.getRow() == 0 ||
                direction == Cursor.Direction.DOWN && cursor.getRow() == grid.getRows() -1 ||
                direction == Cursor.Direction.LEFT && cursor.getCol() == 0 ||
                direction == Cursor.Direction.RIGHT && cursor.getCol() == grid.getCols() -1;

    }
}
