package org.avasyn.command;

import org.avasyn.command.contract.SendCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;

public class LeftCommand implements SendCommand {
    private ToyRobot toyRobot;
    @Override
    public String sendCommand(ToyRobotPosition toyRobotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {
            String output;
            output = String.valueOf(toyRobot.turnLeft());
            return output;
    }
}
