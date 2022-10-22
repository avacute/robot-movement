package org.avasyn.simulation;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ToyRobotTest {
    @Test
    public void testRobotMovement() throws RobotMovementException {

        ToyRobot toyRobot = new ToyRobot(new RobotPosition(0, 0, CardinalDirection.NORTH));
        assertEquals(0, toyRobot.getPosition().getXCoordinate());
        assertEquals(0, toyRobot.getPosition().getYCoordinate());
        assertEquals(CardinalDirection.NORTH, toyRobot.getPosition().getDirection());


        toyRobot.setPosition(new RobotPosition(1, 2, CardinalDirection.EAST));
        toyRobot.rotateLeft();

        assertEquals(1, toyRobot.getPosition().getXCoordinate());
        assertEquals(2, toyRobot.getPosition().getYCoordinate());
        assertEquals(CardinalDirection.NORTH, toyRobot.getPosition().getDirection());

        toyRobot.setPosition(new RobotPosition(0, 0, CardinalDirection.NORTH));
        toyRobot.rotateRight();
        assertEquals(CardinalDirection.EAST, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(CardinalDirection.SOUTH, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(CardinalDirection.WEST, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(CardinalDirection.NORTH, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(CardinalDirection.EAST, toyRobot.getPosition().getDirection());
    }
}
