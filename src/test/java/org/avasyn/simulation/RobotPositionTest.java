package org.avasyn.simulation;

import org.avasyn.util.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RobotPositionTest {

    @Test
    public void changeRobotPosition() throws Exception {
        RobotPosition robotPosition = new RobotPosition(5, 0, Direction.WEST);

        RobotPosition newPosition = robotPosition.changeRobotPosition();
        assertEquals(newPosition.getXCoordinate(), 4);
        assertEquals(newPosition.getYCoordinate(), 0);
        assertEquals(newPosition.getDirection(), Direction.WEST);

        newPosition = newPosition.changeRobotPosition();
        assertNotEquals(newPosition.getXCoordinate(), 1);
        assertEquals(newPosition.getXCoordinate(), 3);
        assertEquals(newPosition.getYCoordinate(), 0);
        assertEquals(newPosition.getDirection(), Direction.WEST);

        newPosition.setDirection(Direction.NORTH);
        newPosition = newPosition.changeRobotPosition();
        assertNotEquals(newPosition.getXCoordinate(), 1);
        assertEquals(newPosition.getYCoordinate(), 1);
        assertEquals(newPosition.getDirection(), Direction.NORTH);
        assertNotEquals(newPosition.getDirection(), Direction.SOUTH);

    }
}
