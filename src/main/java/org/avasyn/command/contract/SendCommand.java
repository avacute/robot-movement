package org.avasyn.command.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.Robot;

public interface SendCommand {
    public String sendCommand(Robot toyRobot) throws RobotMovementException;
}
