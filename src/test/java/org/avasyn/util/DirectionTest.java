package org.avasyn.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testDirectionRotate() throws Exception {
        CardinalDirection cardinalDirection = CardinalDirection.WEST;

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(cardinalDirection, CardinalDirection.SOUTH);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(cardinalDirection, CardinalDirection.EAST);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(cardinalDirection, CardinalDirection.NORTH);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(cardinalDirection, CardinalDirection.WEST);

        cardinalDirection = cardinalDirection.leftDirection();
        assertEquals(cardinalDirection, CardinalDirection.SOUTH);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(cardinalDirection, CardinalDirection.WEST);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(cardinalDirection, CardinalDirection.NORTH);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(cardinalDirection, CardinalDirection.EAST);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(cardinalDirection, CardinalDirection.SOUTH);

        cardinalDirection = cardinalDirection.rightDirection();
        assertEquals(cardinalDirection, CardinalDirection.WEST);
    }
}
