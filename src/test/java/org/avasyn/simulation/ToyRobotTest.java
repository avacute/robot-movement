package org.avasyn.simulation;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ToyRobotTest {
    @Test
    public void testRobotMovement() throws RobotMovementException {

        ToyRobot toyRobot = new ToyRobot(new RobotPosition(0, 0, CardinalDirection.NORTH));
        assertEquals(0, toyRobot.getRobotPosition().getXCoordinate());
        assertEquals(0, toyRobot.getRobotPosition().getYCoordinate());
        assertEquals(CardinalDirection.NORTH, toyRobot.getRobotPosition().getDirection());


        toyRobot.setRobotPosition(new RobotPosition(1, 2, CardinalDirection.EAST));
        toyRobot.turnLeft();

        assertEquals(1, toyRobot.getRobotPosition().getXCoordinate());
        assertEquals(2, toyRobot.getRobotPosition().getYCoordinate());
        assertEquals(CardinalDirection.NORTH, toyRobot.getRobotPosition().getDirection());

        toyRobot.setRobotPosition(new RobotPosition(0, 0, CardinalDirection.NORTH));
        toyRobot.turnRight();
        assertEquals(CardinalDirection.EAST, toyRobot.getRobotPosition().getDirection());
        toyRobot.turnRight();
        assertEquals(CardinalDirection.SOUTH, toyRobot.getRobotPosition().getDirection());
        toyRobot.turnRight();
        assertEquals(CardinalDirection.WEST, toyRobot.getRobotPosition().getDirection());
        toyRobot.turnRight();
        assertEquals(CardinalDirection.NORTH, toyRobot.getRobotPosition().getDirection());
        toyRobot.turnRight();
        assertEquals(CardinalDirection.EAST, toyRobot.getRobotPosition().getDirection());
    }
}
