package org.avasyn.simulation;

import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;

public class ToyRobot implements Robot {
    private RobotPosition toyRobotPosition;

    public ToyRobot() {
    }

    public ToyRobot(RobotPosition toyRobotPosition) {
        this.toyRobotPosition = toyRobotPosition;
    }

    public String setRobotPosition(RobotPosition toyRobotPosition) {
        if (toyRobotPosition == null)
            return "Can't set robot position; invalid position";

        this.toyRobotPosition = toyRobotPosition;
        return "Robot is positioned";
    }


    public String moveRobot(RobotPosition newPosition) {
        if (newPosition == null)
            return "Can't move Robot; robot not on table";

        // change position
        this.toyRobotPosition = newPosition;
        return "Robot move towards " + toyRobotPosition.getDirection();
    }

    public RobotPosition getRobotPosition() {
        if (toyRobotPosition == null)
            return new ToyRobotPosition(0,0,null);
        return this.toyRobotPosition;
    }


    public String turnLeft() {
        if (this.toyRobotPosition == null)
            return "Can't rotate robot; robot not on table";

        // rotate left using leftDirection from Direction enum class
        this.toyRobotPosition.setDirection(this.toyRobotPosition.getDirection().leftDirection());
        return "Robot turned Left: " + toyRobotPosition.getDirection();
    }


    public String turnRight() {
        if (this.toyRobotPosition == null)
            return "Can't rotate robot; robot not on table";

        // rotate right using rightDirection from Direction enum class
        this.toyRobotPosition.setDirection(this.toyRobotPosition.getDirection().rightDirection());
        return "Robot turned Right: " + toyRobotPosition.getDirection();
    }

}

