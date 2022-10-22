package org.avasyn.simulation;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.Table;
import org.avasyn.util.Command;
import org.avasyn.util.CardinalDirection;

public class Simulation {

    private  Table squareTable;
    private ToyRobot toyRobot;

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

        // validate PLACE params
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

        switch (command) {
            case PLACE:
                output = String.valueOf(placeToyRobot(new RobotPosition(x, y, cardinalDirection)));
                break;
            case MOVE:
                RobotPosition newPosition = toyRobot.getPosition().changeRobotPosition();
                if (!squareTable.isValidPosition(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(toyRobot.move(newPosition));
                break;
            case LEFT:
                output = String.valueOf(toyRobot.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(toyRobot.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new RobotMovementException("Invalid command");
        }

        return output;
    }

    public String report() {
        if (toyRobot.getPosition() == null)
            return null;

        return toyRobot.getPosition().getXCoordinate() + "," +
                toyRobot.getPosition().getYCoordinate()+ "," +
                toyRobot.getPosition().getDirection().toString();
    }
}
