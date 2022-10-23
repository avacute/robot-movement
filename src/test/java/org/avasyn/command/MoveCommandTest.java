package org.avasyn.command;

import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveCommandTest {

    @Test
    public void testMoveCommand() throws Exception{
        Table squareTable = new SquareTable(5,5);
        RobotPosition toyRobotPosition = new ToyRobotPosition(0,0, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        MoveCommand moveCommand = new MoveCommand();

        assertEquals("Robot move towards NORTH", moveCommand.sendCommand(
                toyRobotPosition,null, toyRobot));

    }
}
