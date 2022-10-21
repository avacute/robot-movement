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
        if(rows != columns) {
            System.out.println("Not a Square Table");
            return false;
        }

        boolean xOutOfRange = robotPosition.getXCoordinate() > this.rows || robotPosition.getXCoordinate() < 0;
        boolean yOutOfRange = robotPosition.getYCoordinate() > this.columns || robotPosition.getYCoordinate() < 0;

        return !(xOutOfRange || yOutOfRange);
    }
}
