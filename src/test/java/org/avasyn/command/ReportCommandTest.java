package org.avasyn.command;

import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReportCommandTest {

    @Test
    public void testReportCommand() throws Exception{

        RobotPosition toyRobotPosition = new ToyRobotPosition(0,0, CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);

        ReportCommand reportCommand = new ReportCommand();
        assertEquals(  "0,0,NORTH",reportCommand.sendCommand(null,null,toyRobot));


        toyRobot.setRobotPosition(null);
        assertNull(  null,reportCommand.sendCommand(null,null,toyRobot));
    }

}
