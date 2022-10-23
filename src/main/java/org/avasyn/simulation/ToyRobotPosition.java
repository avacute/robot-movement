package org.avasyn.simulation;


import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.CardinalDirection;

public class ToyRobotPosition implements org.avasyn.simulation.contract.RobotPosition {
    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection cardinalDirection;

    public ToyRobotPosition(ToyRobotPosition toyRobotPosition){
        this.xCoordinate = toyRobotPosition.getXCoordinate();
        this.yCoordinate = toyRobotPosition.getYCoordinate();
        this.cardinalDirection = toyRobotPosition.getDirection();
    }
    public ToyRobotPosition(int xCoordinate, int yCoordinate, CardinalDirection cardinalDirection){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.cardinalDirection = cardinalDirection;
    }

    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public CardinalDirection getDirection() {
        return cardinalDirection;
    }

    @Override
    public void setDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    @Override
    public void stepRobotPosition(int x, int y) {
        // add new step move required in x-axis to current x-position
        this.xCoordinate += x;
        // add new step move required in y-axis to current y-position
        this.yCoordinate += y;
    }

    @Override
    public ToyRobotPosition changeRobotPosition() throws RobotMovementException {
        // Check cardinal direction to know if robot is on table
        if (this.cardinalDirection == null)
            throw new RobotMovementException("Robot not placed on Table");

        ToyRobotPosition newPosition  = new ToyRobotPosition(this);

        // move robot by increase or decreasing Coordinates based on current cardinal Direction
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
