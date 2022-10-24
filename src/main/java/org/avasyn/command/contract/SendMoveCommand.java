package org.avasyn.command.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.Table;

public interface SendMoveCommand {

    public String sendCommand(Table squareTable, Simulation simulation, Robot toyRobot) throws RobotMovementException;
}
