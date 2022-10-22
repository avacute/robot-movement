package org.avasyn.simulation;

import org.avasyn.simulation.contract.Robot;

public class ToyRobot implements Robot {
    private RobotPosition robotPosition;

    public ToyRobot() {
    }

    public ToyRobot(RobotPosition robotPosition) {
        this.robotPosition = robotPosition;
    }

    public String setRobotPosition(RobotPosition robotPosition) {
        if (robotPosition == null)
            return "Can't set robot position; invalid position";

        this.robotPosition = robotPosition;
        return "Robot is positioned";
    }


    public String moveRobot(RobotPosition newPosition) {
        if (newPosition == null)
            return "Can't move Robot; robot not on table";

        // change position
        this.robotPosition = newPosition;
        return "Robot move towards " + robotPosition.getDirection();
    }

    public RobotPosition getRobotPosition() {
        if (robotPosition == null)
            return new RobotPosition(0,0,null);
        return this.robotPosition;
    }


    public String turnLeft() {
        if (this.robotPosition == null)
            return "Can't rotate robot; robot not on table";

        // rotate left using leftDirection from Direction enum class
        this.robotPosition.setDirection(this.robotPosition.getDirection().leftDirection());
        return "Robot turned Left: " + robotPosition.getDirection();
    }


    public String turnRight() {
        if (this.robotPosition == null)
            return "Can't rotate robot; robot not on table";

        // rotate right using rightDirection from Direction enum class
        this.robotPosition.setDirection(this.robotPosition.getDirection().rightDirection());
        return "Robot turned Right: " + robotPosition.getDirection();
    }

}

