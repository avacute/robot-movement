package org.avasyn.command;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.Table;
import org.avasyn.util.CardinalDirection;

public class SendCommandFactory {

    // get command and execute the right send command implementation
    public String executeCommand(Command command, int x, int y,
                                  CardinalDirection cardinalDirection,
                                  Robot toyRobot,
                                  Simulation simulation, Table squareTable
    ) throws RobotMovementException {

        if (command == Command.PLACE) {
            return new PlaceCommand().sendCommand(squareTable,
                    new ToyRobotPosition(x, y, cardinalDirection),
                    simulation);
        }

        if (command == Command.MOVE) {
            return new MoveCommand().sendCommand(squareTable,simulation, toyRobot);
        }

        if (command == Command.LEFT) {
            return new LeftCommand().sendCommand(toyRobot);
        }

        if (command == Command.RIGHT) {
            return new RightCommand().sendCommand( toyRobot);
        }

        if (command == Command.REPORT) {
            return new ReportCommand().sendCommand(toyRobot);
        }

        return null;
    }
}
