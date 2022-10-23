package org.avasyn.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testDirectionRotate() {
        CardinalDirection cardinalDirection = CardinalDirection.WEST;

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(CardinalDirection.SOUTH,cardinalDirection);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(CardinalDirection.EAST,cardinalDirection);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(CardinalDirection.NORTH,cardinalDirection);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(CardinalDirection.WEST,cardinalDirection);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(CardinalDirection.SOUTH,cardinalDirection);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(CardinalDirection.WEST,cardinalDirection);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(CardinalDirection.NORTH,cardinalDirection);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(CardinalDirection.EAST,cardinalDirection);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(CardinalDirection.SOUTH,cardinalDirection);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(CardinalDirection.WEST,cardinalDirection);
    }
}
