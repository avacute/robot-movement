package org.avasyn.simulation;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ToyRobotPositionTest {
     @Test
     public void changeRobotPosition() throws RobotMovementException {
        RobotPosition toyRobotPosition = new ToyRobotPosition(5, 0, CardinalDirection.WEST);

        RobotPosition newPosition = toyRobotPosition.changeRobotPosition();
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
