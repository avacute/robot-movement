package org.avasyn.simulation;

import org.avasyn.exception.ToyRobotMovementException;
import org.avasyn.util.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ToyRobotTest {
    @Test
    public void testRobotMovement() throws ToyRobotMovementException{

        ToyRobot toyRobot = new ToyRobot(new RobotPosition(0, 0, Direction.NORTH));
        assertEquals(0, toyRobot.getPosition().getXCoordinate());
        assertEquals(0, toyRobot.getPosition().getYCoordinate());
        assertEquals(Direction.NORTH, toyRobot.getPosition().getDirection());


        toyRobot.setPosition(new RobotPosition(1, 2, Direction.EAST));
        toyRobot.rotateLeft();

        assertEquals(1, toyRobot.getPosition().getXCoordinate());
        assertEquals(2, toyRobot.getPosition().getYCoordinate());
        assertEquals(Direction.NORTH, toyRobot.getPosition().getDirection());

        toyRobot.setPosition(new RobotPosition(0, 0, Direction.NORTH));
        toyRobot.rotateRight();
        assertEquals(Direction.EAST, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(Direction.SOUTH, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(Direction.WEST, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(Direction.NORTH, toyRobot.getPosition().getDirection());
        toyRobot.rotateRight();
        assertEquals(Direction.EAST, toyRobot.getPosition().getDirection());
    }
}
