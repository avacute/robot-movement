package org.avasyn.simulation;

import org.avasyn.simulation.contract.Table;
import org.junit.jupiter.api.Test;

import static org.avasyn.util.CardinalDirection.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquareTableTest {

    @Test
    public void testIsValidPosition(){
        // test valid positions
        Table squareTable = new SquareTable(5,5);
        assertTrue(squareTable.isValidPosition(new ToyRobotPosition(0,0, NORTH)));
        assertTrue(squareTable.isValidPosition(new ToyRobotPosition(5,0, WEST)));
        assertTrue(squareTable.isValidPosition(new ToyRobotPosition(0,0, EAST)));
        assertTrue(squareTable.isValidPosition(new ToyRobotPosition(0,5, SOUTH)));

        // test invalid positions
        assertFalse(squareTable.isValidPosition(new ToyRobotPosition(0,6, NORTH)));
        assertFalse(squareTable.isValidPosition(new ToyRobotPosition(-1,0, WEST)));
        assertFalse(squareTable.isValidPosition(new ToyRobotPosition(6,0, EAST)));
        assertFalse(squareTable.isValidPosition(new ToyRobotPosition(0,-1, SOUTH)));
    }
}
