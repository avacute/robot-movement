package org.avasyn.util;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.RobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.util.contract.SendCommand;
import org.avasyn.simulation.contract.Table;

public class MoveCommand implements SendCommand {

    private Table squareTable;

    @Override
    public String sendCommand(RobotPosition robotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException {
        String output;
        squareTable = new SquareTable(5,5);
        robotPosition = toyRobot.getPosition().changeRobotPosition();
        if (!squareTable.isValidPosition(robotPosition))
            output = String.valueOf(false);
        else
            output = String.valueOf(toyRobot.move(robotPosition));
        return output;
    }
}
