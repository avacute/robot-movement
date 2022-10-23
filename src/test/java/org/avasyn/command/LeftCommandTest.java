package org.avasyn.command;

import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftCommandTest {
    @Test
    public void testLeftCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0,0, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        LeftCommand leftCommand = new LeftCommand();
        assertEquals("Robot turned Left: WEST", leftCommand.sendCommand(null,null, toyRobot));
        toyRobot = new ToyRobot(null);
        assertEquals("Can't rotate robot; robot not on table", leftCommand.sendCommand(null,null, toyRobot));
    }
}
