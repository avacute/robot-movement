package org.avasyn.command;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.command.contract.SendMoveCommand;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;

public class MoveCommand implements SendMoveCommand {

    @Override
    public String sendCommand(Table squareTable, Simulation simulation, Robot toyRobot) throws RobotMovementException {
        String output;
        RobotPosition newToyRobotPosition;
        newToyRobotPosition = toyRobot.getRobotPosition().changeRobotPosition();
        if (!squareTable.isValidPosition(newToyRobotPosition))
            output = String.valueOf(false);
        else
            output = String.valueOf(toyRobot.moveRobot(newToyRobotPosition));
        return output;
    }
}
