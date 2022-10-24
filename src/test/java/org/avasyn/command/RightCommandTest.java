package org.avasyn.command;

import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightCommandTest {

    @Test
    public void testRightCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0,0, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        RightCommand rightCommand = new RightCommand();

        assertEquals("Robot turned Right: EAST", rightCommand.sendCommand(toyRobot));

        toyRobot = new ToyRobot(null);
        assertEquals("Can't rotate robot; robot not on table", rightCommand.sendCommand(toyRobot));
    }
}
