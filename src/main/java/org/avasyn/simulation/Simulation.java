package org.avasyn.simulation;
import org.avasyn.command.SendCommandFactory;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.*;
import org.avasyn.command.Command;
import org.avasyn.command.contract.SendCommand;
import org.avasyn.simulation.contract.Table;

public class Simulation {

    private  Table squareTable;
    private ToyRobot toyRobot;

    private SendCommand sendCommand;

    private SendCommandFactory sendCommandFactory;

    public Simulation (Table squareTable, ToyRobot toyRobot) {
        // set squareTable to injected object
        this.squareTable= squareTable;
        // set toyRobot to injected object
        this.toyRobot = toyRobot;
    }

    public String placeRobotTable(ToyRobotPosition toyRobotPosition) throws RobotMovementException {

        if (squareTable == null)
            throw new RobotMovementException("Invalid squareBoard object");

        if (toyRobotPosition == null)
            throw new RobotMovementException("Invalid position object");

        if (toyRobotPosition.getDirection() == null)
            throw new RobotMovementException("Invalid direction value");

        // validate the position
        if (!squareTable.isValidPosition(toyRobotPosition))
            return "Invalid position";

        // if position is valid then assign values to fields
        toyRobot.setRobotPosition(toyRobotPosition);
        return "Robot placed on Table";
    }

    public String robotMovement(String inputString) throws RobotMovementException {

        // split input String by space
        String[] prams = inputString.split(" ");

        // validate command
        Command command;
        try {
            command = Command.valueOf(prams[0]);
        } catch (IllegalArgumentException e) {
            throw new RobotMovementException("Invalid command");
        }

        // invalid Command if command is PLACE parameters less the 2
        if (command == Command.PLACE && prams.length < 2)
            throw new RobotMovementException("Invalid command");


        // validate PLACE Command parameters
        String[] params;
        int x = 0;
        int y = 0;
        CardinalDirection cardinalDirection = null;
        if (command == Command.PLACE) {
            // separate second parameter by comma ','
            params = prams[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                cardinalDirection = CardinalDirection.valueOf(params[2]);
            } catch (Exception e) {
                throw new RobotMovementException("Invalid command");
            }
        }

        // create sendCommandFactory object
        sendCommandFactory = new SendCommandFactory();
        // execute command
        return sendCommandFactory.executeCommand(command, x, y, cardinalDirection,toyRobot,this);


    }
}
