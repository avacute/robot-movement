package org.avasyn.simulation;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;

public class SquareTable implements Table {
    private int rows;
    private int columns;

    public SquareTable(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    public boolean isValidPosition(RobotPosition toyRobotPosition) {
        // Check if move is with the table row range
        boolean xOutOfRange = toyRobotPosition.getXCoordinate() > this.rows || toyRobotPosition.getXCoordinate() < 0;

        // Check if move is with the table column range
        boolean yOutOfRange = toyRobotPosition.getYCoordinate() > this.columns || toyRobotPosition.getYCoordinate() < 0;

        // return true when  move is with table range and false when not in range
        return !(xOutOfRange || yOutOfRange);
    }
}
