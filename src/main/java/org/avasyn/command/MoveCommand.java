package org.avasyn.command;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.command.contract.SendCommand;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;

public class MoveCommand implements SendCommand {

    @Override
    public String sendCommand(RobotPosition toyRobotPosition, Simulation simulation, Robot toyRobot) throws RobotMovementException {
        String output;
        Table squareTable = new SquareTable(5,5);
        RobotPosition newToyRobotPosition;
        newToyRobotPosition = toyRobot.getRobotPosition().changeRobotPosition();
        if (!squareTable.isValidPosition(newToyRobotPosition))
            output = String.valueOf(false);
        else
            output = String.valueOf(toyRobot.moveRobot(newToyRobotPosition));
        return output;
    }
}
