package org.bootcamp;


import org.bootcamp.cells.Cell;
import org.bootcamp.utils.FileLoader;

public class Grid {

    public static final int CELLSIZE = 15;
    public static final int GRIDSIZE = 20;

    private Cell[][] cells;

    public Grid() {
        cells = new Cell[GRIDSIZE][GRIDSIZE];

        for (int row = 0; row < GRIDSIZE; row++) {
            for (int col = 0; col < GRIDSIZE; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }

        stringToWalls();
    }


    private void stringToWalls(){

        String gridInText = FileLoader.readFile();

        //THIS IS JUST TO SHOW YOU WHAT THE EQUIVALENT LOOP AS THE ONE BELOW WOULD LOOK LIKE IN A FOR-I IMPLEMENTATION
/*
        int index = 0;
        for (int row = 0; row < GRIDSIZE; row++) {
            for (int col = 0; col < GRIDSIZE; col++) {
                if(gridInText.charAt(index) == '1'){
                    cells[row][col].becomeWall();
                }
                index++;
            }
        }
*/
        int index = 0;
        for (Cell[] arr: cells) {
            for (Cell cell: arr) {
                if(gridInText.charAt(index) == '1'){
                    cell.becomeWall();
                }
                index++;
            }
        }
    }

    public boolean isValidMove(int row, int col, Direction direction) {
        return isValidEdge(row, col, direction) && isValidCell(row, col, direction);
    }

    private boolean isValidCell(int row, int col, Direction direction) {
        boolean isValid = true;

        switch (direction) {
            case RIGHT:
                isValid = !(cells[row][col+1].isWall());
                break;
            case LEFT:
                isValid = !(cells[row][col-1].isWall());
                break;
            case DOWN:
                isValid = !(cells[row+1][col].isWall());
                break;
            case UP:
                isValid = !(cells[row-1][col].isWall());
                break;
        }

        return isValid;
    }

    private boolean isValidEdge(int row, int col, Direction direction) {
        return !(col == 0 && direction == Direction.LEFT ||
                col == GRIDSIZE - 1 && direction == Direction.RIGHT ||
                row == 0 && direction == Direction.UP ||
                row == GRIDSIZE - 1 && direction == Direction.DOWN);
    }

}
