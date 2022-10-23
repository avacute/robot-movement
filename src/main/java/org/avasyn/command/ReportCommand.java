package org.avasyn.command;

import org.avasyn.command.contract.SendCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;

public class ReportCommand implements SendCommand {


    @Override
    public String sendCommand(RobotPosition toyRobotPosition, Simulation simulation, Robot toyRobot) throws RobotMovementException {
        if (toyRobot.getRobotPosition() == null)
            return null;

        return toyRobot.getRobotPosition().getXCoordinate() + "," +
                toyRobot.getRobotPosition().getYCoordinate()+ "," +
                toyRobot.getRobotPosition().getDirection().toString();
    }
}
