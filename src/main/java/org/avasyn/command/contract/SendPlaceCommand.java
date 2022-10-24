package org.avasyn.command.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;

public interface SendPlaceCommand {

    public String sendCommand(Table squareTable, RobotPosition toyRobotPosition, Simulation simulation) throws RobotMovementException;
}
