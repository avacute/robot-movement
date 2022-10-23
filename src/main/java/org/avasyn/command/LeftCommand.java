package org.avasyn.command;

import org.avasyn.command.contract.SendCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;

public class LeftCommand implements SendCommand {
    @Override
    public String sendCommand(RobotPosition toyRobotPosition, Simulation simulation, Robot toyRobot) throws RobotMovementException {
            return String.valueOf(toyRobot.turnLeft());

    }
}
