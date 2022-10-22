package org.avasyn.simulation;
import org.avasyn.simulation.contract.Table;

public class SquareTable implements Table {
    private int rows;
    private int columns;

    public SquareTable(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    public boolean isValidPosition(RobotPosition robotPosition) {
        // check for square table
        if(rows != columns) {
            System.out.println("Not a square table");
            return false;
        }
        // Check if move is with the table row range
        boolean xOutOfRange = robotPosition.getXCoordinate() > this.rows || robotPosition.getXCoordinate() < 0;

        // Check if move is with the table column range
        boolean yOutOfRange = robotPosition.getYCoordinate() > this.columns || robotPosition.getYCoordinate() < 0;

        // return true when  move is with table range and false when not in range
        return !(xOutOfRange || yOutOfRange);
    }
}
