package org.avasyn.simulation.contract;

import org.avasyn.simulation.ToyRobotPosition;

public interface Table {
    public boolean isValidPosition(ToyRobotPosition toyRobotPosition);
}