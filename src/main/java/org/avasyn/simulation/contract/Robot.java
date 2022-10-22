package org.avasyn.simulation.contract;

import org.avasyn.simulation.RobotPosition;

public interface Robot {
    public String turnRight();
    public String turnLeft();
    public String moveRobot(RobotPosition robotPosition);
    public String setRobotPosition(RobotPosition robotPosition);
}
