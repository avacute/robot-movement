package org.avasyn.simulation;


import org.avasyn.exception.ToyRobotMovementException;
import org.avasyn.simulation.contract.Robot;

public class ToyRobot implements Robot {
    private RobotPosition robotPosition;

    public ToyRobot() {
    }

    public ToyRobot(RobotPosition robotPosition) {
        this.robotPosition = robotPosition;
    }

    public String setPosition(RobotPosition robotPosition) {
        if (robotPosition == null)
            return "Can't set robot position; invalid position";

        this.robotPosition = robotPosition;
        return "Robot is positioned";
    }


    public String move(RobotPosition newPosition) {
        if (newPosition == null)
            return "Can't move Robot; robot not on table";

        // change position
        this.robotPosition = newPosition;
        return "Robot move towards " + robotPosition.getDirection();
    }

    public RobotPosition getPosition() {
        if (robotPosition == null)
            return new RobotPosition(0,0,null);
        return this.robotPosition;
    }


    public String rotateLeft() {
        if (this.robotPosition == null)
            return "Can't rotate robot; robot not on table";

        this.robotPosition.setDirection(this.robotPosition.getDirection().leftDirection());
        return "Robot turned Left: " + robotPosition.getDirection();
    }


    public String rotateRight() {
        if (this.robotPosition == null)
            return "Can't rotate robot; robot not on table";

        this.robotPosition.setDirection(this.robotPosition.getDirection().rightDirection());
        return "Robot turned Right: " + robotPosition.getDirection();
    }

}

