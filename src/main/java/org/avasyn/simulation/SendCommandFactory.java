package org.avasyn.simulation;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.CardinalDirection;
import org.avasyn.util.Command;
import org.avasyn.util.sendcommand.*;

public class SendCommandFactory {

    // get command and execute the right send command implementation
    public String executeCommand(Command command, int x, int y,
                                  CardinalDirection cardinalDirection,
                                  ToyRobot toyRobot,
                                  Simulation simulation
    ) throws RobotMovementException {

        if (command == Command.PLACE) {
            return new PlaceCommand().sendCommand(
                    new RobotPosition(x, y, cardinalDirection),
                    simulation, toyRobot);
        }

        if (command == Command.MOVE) {
            return new MoveCommand().sendCommand(
                    toyRobot.getRobotPosition().changeRobotPosition(),
                    simulation, toyRobot);
        }

        if (command == Command.LEFT) {
            return new LeftCommand().sendCommand(
                    toyRobot.getRobotPosition().changeRobotPosition(),
                    simulation, toyRobot);
        }

        if (command == Command.RIGHT) {
            return new RightCommand().sendCommand(
                    toyRobot.getRobotPosition().changeRobotPosition(),
                    simulation, toyRobot);
        }

        if (command == Command.REPORT) {
            return new ReportCommand().sendCommand(
                    toyRobot.getRobotPosition().changeRobotPosition(),
                    simulation, toyRobot);
        }

        return null;
    }
}
