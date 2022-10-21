package org.avasyn.simulation.contract;

import org.avasyn.simulation.RobotPosition;

public interface Table {
    public boolean isValidPosition(RobotPosition robotPosition);
}