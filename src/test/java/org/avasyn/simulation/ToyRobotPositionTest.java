package org.avasyn.simulation;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ToyRobotPositionTest {
     @Test
     public void testChangeRobotPosition() throws RobotMovementException {
        RobotPosition toyRobotPosition = new ToyRobotPosition(5, 0, CardinalDirection.WEST);

        RobotPosition newPosition = toyRobotPosition.changeRobotPosition();
        assertEquals(4,newPosition.getXCoordinate());
        assertEquals(0,newPosition.getYCoordinate());
        assertEquals(CardinalDirection.WEST,newPosition.getDirection());

        newPosition = newPosition.changeRobotPosition();
        assertNotEquals(1,newPosition.getXCoordinate());
        assertEquals(3,newPosition.getXCoordinate());
        assertEquals(0,newPosition.getYCoordinate());
        assertEquals(CardinalDirection.WEST,newPosition.getDirection());

        newPosition.setDirection(CardinalDirection.NORTH);
        newPosition = newPosition.changeRobotPosition();
        assertNotEquals(1,newPosition.getXCoordinate());
        assertEquals(1,newPosition.getYCoordinate());
        assertEquals(CardinalDirection.NORTH,newPosition.getDirection());
        assertNotEquals(CardinalDirection.SOUTH,newPosition.getDirection());

    }
}
