package org.avasyn.command;

import org.avasyn.command.contract.SendCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;

public class ReportCommand implements SendCommand {

    private ToyRobot toyRobot;

    @Override
    public String sendCommand(ToyRobotPosition toyRobotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {
        if (toyRobot.getRobotPosition() == null)
            return null;

        return toyRobot.getRobotPosition().getXCoordinate() + "," +
                toyRobot.getRobotPosition().getYCoordinate()+ "," +
                toyRobot.getRobotPosition().getDirection().toString();
    }
}
