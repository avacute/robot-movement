package org.avasyn.simulation;


import org.avasyn.exception.ToyRobotMovementException;
import org.avasyn.util.Direction;

public class RobotPosition {
    private int xCoordinate;
    private int yCoordinate;
    private Direction direction;

    public RobotPosition(RobotPosition robotPosition){
        this.xCoordinate = robotPosition.getXCoordinate();
        this.yCoordinate = robotPosition.getYCoordinate();
        this.direction = robotPosition.getDirection();
    }
    public RobotPosition(int xCoordinate, int yCoordinate,Direction direction){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.direction = direction;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void stepRobotPosition(int x, int y) {
        // add new step move required in x-axis to current x-position
        this.xCoordinate += x;
        // add new step move required in y-axis to current y-position
        this.yCoordinate += y;
    }

    public RobotPosition changeRobotPosition() throws ToyRobotMovementException {

        if (this.direction == null)
            throw new ToyRobotMovementException("Invalid robot direction");

        RobotPosition newPosition  = new RobotPosition(this);
        switch (this.direction) {
            case NORTH:
                newPosition.stepRobotPosition(0, 1);
                break;
            case EAST:
                newPosition.stepRobotPosition(1, 0);
                break;
            case SOUTH:
                newPosition.stepRobotPosition(0, -1);
                break;
            case WEST:
                newPosition.stepRobotPosition(-1, 0);
                break;
        }

        // return new position
        return newPosition;
    }

}
