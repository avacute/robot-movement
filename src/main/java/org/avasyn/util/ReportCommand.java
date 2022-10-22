package org.avasyn.util;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.RobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.util.contract.SendCommand;

public class ReportCommand implements SendCommand {

    private ToyRobot toyRobot;

    @Override
    public String sendCommand(RobotPosition robotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {
        if (toyRobot.getPosition() == null)
            return null;

        return toyRobot.getPosition().getXCoordinate() + "," +
                toyRobot.getPosition().getYCoordinate()+ "," +
                toyRobot.getPosition().getDirection().toString();
    }
}
