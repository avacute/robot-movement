package org.avasyn.simulation;


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
            return "Can't set Robot Position; Invalid Position";

        this.robotPosition = robotPosition;
        return "Robot is Positioned";
    }


    public String move(RobotPosition newPosition) {
        if (newPosition == null)
            return "Can't move Robot; Invalid Position";;

        // change position
        this.robotPosition = newPosition;
        return "Robot move towards " + robotPosition.getDirection();
    }

    public RobotPosition getPosition() {
        return this.robotPosition;
    }


    public String rotateLeft() {
        if (this.robotPosition.getDirection()== null)
            return "Can't Rotate Robot; Invalid Direction";

        this.robotPosition.setDirection(this.robotPosition.getDirection().leftDirection());
        return "Robot turned Left: " + robotPosition.getDirection();
    }


    public String rotateRight() {
        if (this.robotPosition.getDirection() == null)
            return "Can't Rotate Robot; Invalid Direction";

        this.robotPosition.setDirection(this.robotPosition.getDirection().rightDirection());
        return "Robot turned Right: " + robotPosition.getDirection();
    }

}

