package org.avasyn.simulation;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.*;
import org.avasyn.util.contract.SendCommand;
import org.avasyn.simulation.contract.Table;

public class Simulation {

    private  Table squareTable;
    private ToyRobot toyRobot;

    private SendCommand sendCommand;

    public Simulation (Table squareTable, ToyRobot toyRobot) {
        this.squareTable= squareTable;
        this.toyRobot = toyRobot;
    }

    public String placeToyRobot(RobotPosition robotPosition) throws RobotMovementException {

        if (squareTable == null)
            throw new RobotMovementException("Invalid squareBoard object");

        if (robotPosition == null)
            throw new RobotMovementException("Invalid position object");

        if (robotPosition.getDirection() == null)
            throw new RobotMovementException("Invalid direction value");

        // validate the position
        if (!squareTable.isValidPosition(robotPosition))
            return "Invalid position";

        // if position is valid then assign values to fields
        toyRobot.setPosition(robotPosition);
        return "Robot placed on Table";
    }

    public String robotMovement(String inputString) throws RobotMovementException {


        String[] args = inputString.split(" ");

        // validate command
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new RobotMovementException("Invalid command");
        }

        // invalid Command
        if (command == Command.PLACE && args.length < 2) {
            throw new RobotMovementException("Invalid command");
        }

        // validate PLACE Command parameters
        String[] params;
        int x = 0;
        int y = 0;
        CardinalDirection cardinalDirection = null;
        if (command == Command.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                cardinalDirection = CardinalDirection.valueOf(params[2]);
            } catch (Exception e) {
                throw new RobotMovementException("Invalid command");
            }
        }

        String output;
        output = null;
        output = executeCommand(command, x, y, cardinalDirection, output);
        return output;

    }

    private String executeCommand(Command command, int x, int y,
                                  CardinalDirection cardinalDirection,
                                  String output) throws RobotMovementException {
        if (command.equals(Command.PLACE)) {
            output = new PlaceCommand().sendCommand(new RobotPosition(x, y, cardinalDirection), this, toyRobot);
        }

        if (command.equals(Command.MOVE)) {
            output = new MoveCommand().sendCommand(toyRobot.getPosition().changeRobotPosition(), this, toyRobot);
        }

        if (command.equals(Command.LEFT)) {
            output = new LeftCommand().sendCommand(toyRobot.getPosition().changeRobotPosition(), this, toyRobot);
        }

        if (command.equals(Command.RIGHT)) {
            output = new RightCommand().sendCommand(toyRobot.getPosition().changeRobotPosition(), this, toyRobot);
        }

        if (command.equals(Command.REPORT)) {
            output = new ReportCommand().sendCommand(toyRobot.getPosition().changeRobotPosition(), this, toyRobot);
        }

        if (output == null) {
            throw new RobotMovementException("Invalid command");
        }
        return output;
    }
}
