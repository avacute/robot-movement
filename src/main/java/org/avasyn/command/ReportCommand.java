package org.avasyn.command;

import org.avasyn.command.contract.SendCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.Robot;

public class ReportCommand implements SendCommand {


    @Override
    public String sendCommand(Robot toyRobot) throws RobotMovementException {
        if (toyRobot.getRobotPosition() == null)
            return null;

        return toyRobot.getRobotPosition().getXCoordinate() + "," +
                toyRobot.getRobotPosition().getYCoordinate()+ "," +
                toyRobot.getRobotPosition().getDirection().toString();
    }
}
