package org.avasyn.util.sendcommand;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.RobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.util.sendcommand.contract.SendCommand;

public class ReportCommand implements SendCommand {

    private ToyRobot toyRobot;

    @Override
    public String sendCommand(RobotPosition robotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {
        if (toyRobot.getRobotPosition() == null)
            return null;

        return toyRobot.getRobotPosition().getXCoordinate() + "," +
                toyRobot.getRobotPosition().getYCoordinate()+ "," +
                toyRobot.getRobotPosition().getDirection().toString();
    }
}
