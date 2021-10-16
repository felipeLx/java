package names;

import java.util.ArrayList;
import java.util.List;

public class NamesAll {

    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;
    private final static int WORK_DAYS_PER_WEEK = 5;


    public List<Cell> getFlaggedCells() {
        List<Cell> flaggerCells = new ArrayList<Cell>();

        for (Cell cell : gameBoard) {
            if(cell.isFlagged()) {
                flaggerCells.add(cell);
            }

        } return flaggerCells;
    }

    public void testVariableNames() {

        int sum = 0;

        for (int i = 0; i < NUMBER_OF_TASKS; i++) {

            int realTaskDays = taskEstimate[i] * realDaysPerIdealDay;
            int realTaskWeeks = (realdays /  WORK_DAYS_PER_WEEK);

            sum += realTaskWeeks;
        }

    }

    public static void main(String[] args) {

        NamesAll namesAll = new NamesAll();

        namesAll.getFlaggedCells();
    }

}
