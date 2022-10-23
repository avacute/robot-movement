package org.avasyn.command;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaceCommandTest {


    @Test
    public void testPlaceCommandWIthNullRobotPosition() {

        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Simulation simulation = new Simulation(null, toyRobot);
        PlaceCommand placeCommand= new PlaceCommand();
        assertThrows(RobotMovementException.class, () -> {
            placeCommand.sendCommand(toyRobotPosition,simulation,toyRobot);
        }, "Invalid position object");
    }

    @Test
    public void testPlaceCommandWIthNullDirection() {

        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0,null);
        Robot toyRobot = new ToyRobot(null);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);

        PlaceCommand placeCommand= new PlaceCommand();
        assertThrows(RobotMovementException.class, () -> {
            placeCommand.sendCommand(toyRobotPosition,simulation,toyRobot);
        }, "Invalid direction value");

    }

    @Test
    public void testPlaceCommandWIthNullInvalidPosition() throws Exception{

        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 6, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);

        PlaceCommand placeCommand= new PlaceCommand();

        assertEquals("Invalid position",placeCommand.sendCommand(toyRobotPosition,simulation,toyRobot));
    }


    @Test
    public void testPlaceCommandValidInput() throws Exception{

        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);

        PlaceCommand placeCommand= new PlaceCommand();

        assertEquals("Robot placed on Table",placeCommand.sendCommand(toyRobotPosition,simulation,toyRobot));

    }
}
