package org.avasyn.util.sendcommand;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.RobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.util.sendcommand.contract.SendCommand;

public class RightCommand implements SendCommand {

    private ToyRobot toyRobot;

    @Override
    public String sendCommand(RobotPosition robotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {

            String output;
            output = String.valueOf(toyRobot.turnRight());
            return output;
    }
}
