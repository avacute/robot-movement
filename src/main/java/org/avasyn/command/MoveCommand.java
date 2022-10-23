package org.avasyn.command;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.command.contract.SendCommand;
import org.avasyn.simulation.contract.Table;

public class MoveCommand implements SendCommand {

    private Table squareTable;

    @Override
    public String sendCommand(ToyRobotPosition toyRobotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {
        String output;
        squareTable = new SquareTable(5,5);
        toyRobotPosition = toyRobot.getRobotPosition().changeRobotPosition();
        if (!squareTable.isValidPosition(toyRobotPosition))
            output = String.valueOf(false);
        else
            output = String.valueOf(toyRobot.moveRobot(toyRobotPosition));
        return output;
    }
}
