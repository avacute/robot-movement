package org.avasyn.command;

import org.avasyn.command.contract.SendCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.Robot;

public class LeftCommand implements SendCommand {
    @Override
    public String sendCommand(Robot toyRobot) throws RobotMovementException {
            return String.valueOf(toyRobot.turnLeft());

    }
}
