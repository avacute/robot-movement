package org.avasyn.simulation;

import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RobotPositionTest {

    @Test
    public void changeRobotPosition() throws Exception {
        RobotPosition robotPosition = new RobotPosition(5, 0, CardinalDirection.WEST);

        RobotPosition newPosition = robotPosition.changeRobotPosition();
        assertEquals(newPosition.getXCoordinate(), 4);
        assertEquals(newPosition.getYCoordinate(), 0);
        assertEquals(newPosition.getDirection(), CardinalDirection.WEST);

        newPosition = newPosition.changeRobotPosition();
        assertNotEquals(newPosition.getXCoordinate(), 1);
        assertEquals(newPosition.getXCoordinate(), 3);
        assertEquals(newPosition.getYCoordinate(), 0);
        assertEquals(newPosition.getDirection(), CardinalDirection.WEST);

        newPosition.setDirection(CardinalDirection.NORTH);
        newPosition = newPosition.changeRobotPosition();
        assertNotEquals(newPosition.getXCoordinate(), 1);
        assertEquals(newPosition.getYCoordinate(), 1);
        assertEquals(newPosition.getDirection(), CardinalDirection.NORTH);
        assertNotEquals(newPosition.getDirection(), CardinalDirection.SOUTH);

    }
}
