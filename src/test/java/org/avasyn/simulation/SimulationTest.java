package org.avasyn.simulation;


import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.Table;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    private Table squareTable;
    private Robot toyRobot;
    private Simulation simulation;

    @Test
    public void testPlaceRobotTable() throws RobotMovementException {
        squareTable = new SquareTable(5,5);
        toyRobot  = new ToyRobot();
        simulation = new Simulation(squareTable,toyRobot);
        assertEquals("Robot placed on Table", simulation.placeRobotTable(new ToyRobotPosition(
                0, 0, CardinalDirection.NORTH)));
        assertEquals("Invalid position", simulation.placeRobotTable(new ToyRobotPosition(
                0, 6, CardinalDirection.NORTH)));
        assertNotEquals("Invalid position", simulation.placeRobotTable(new ToyRobotPosition(
                0, 0, CardinalDirection.NORTH)));
    }

    @Test
    public void testRobotMovement() throws RobotMovementException {
        squareTable = new SquareTable(5,5);
        toyRobot  = new ToyRobot();
        simulation = new Simulation(squareTable,toyRobot);

        assertThrows(RobotMovementException.class, () -> {
            simulation.robotMovement("MOVE");}, "Invalid command");
    }
}

