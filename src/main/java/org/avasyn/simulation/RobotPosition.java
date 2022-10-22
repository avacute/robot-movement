package org.avasyn.simulation;


import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.CardinalDirection;

public class RobotPosition {
    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection cardinalDirection;

    public RobotPosition(RobotPosition robotPosition){
        this.xCoordinate = robotPosition.getXCoordinate();
        this.yCoordinate = robotPosition.getYCoordinate();
        this.cardinalDirection = robotPosition.getDirection();
    }
    public RobotPosition(int xCoordinate, int yCoordinate, CardinalDirection cardinalDirection){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.cardinalDirection = cardinalDirection;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public CardinalDirection getDirection() {
        return cardinalDirection;
    }

    public void setDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public void stepRobotPosition(int x, int y) {

        // add new step move required in x-axis to current x-position
        this.xCoordinate += x;
        // add new step move required in y-axis to current y-position
        this.yCoordinate += y;
    }

    public RobotPosition changeRobotPosition() throws RobotMovementException {

        if (this.cardinalDirection == null)
            throw new RobotMovementException("Robot not placed on Table");

        RobotPosition newPosition  = new RobotPosition(this);
        switch (this.cardinalDirection) {
            case WEST:
                newPosition.stepRobotPosition(-1, 0);
                break;
            case EAST:
                newPosition.stepRobotPosition(1, 0);
                break;
            case NORTH:
                newPosition.stepRobotPosition(0, 1);
                break;
            case SOUTH:
                newPosition.stepRobotPosition(0, -1);
                break;
        }

        // return new position
        return newPosition;
    }

}
