package org.avasyn.command.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;

public interface SendCommand {

    public String sendCommand(RobotPosition toyRobotPosition, Simulation simulation, Robot toyRobot) throws RobotMovementException;
}
