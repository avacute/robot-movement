package org.avasyn.simulation.contract;

import org.avasyn.simulation.RobotPosition;

public interface Robot {
    public String rotateRight();
    public String rotateLeft();
    public String move(RobotPosition robotPosition);
    public String setPosition(RobotPosition robotPosition);
}
