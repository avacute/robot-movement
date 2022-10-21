package org.avasyn.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testDirectionRotate() throws Exception {
        Direction direction = Direction.WEST;

        direction = direction.leftDirection();
        assertEquals(direction, Direction.SOUTH);

        direction = direction.leftDirection();
        assertEquals(direction, Direction.EAST);

        direction = direction.leftDirection();
        assertEquals(direction, Direction.NORTH);

        direction = direction.leftDirection();
        assertEquals(direction, Direction.WEST);

        direction = direction.leftDirection();
        assertEquals(direction, Direction.SOUTH);

        direction = direction.rightDirection();
        assertEquals(direction, Direction.WEST);

        direction = direction.rightDirection();
        assertEquals(direction, Direction.NORTH);

        direction = direction.rightDirection();
        assertEquals(direction, Direction.EAST);

        direction = direction.rightDirection();
        assertEquals(direction, Direction.SOUTH);

        direction = direction.rightDirection();
        assertEquals(direction, Direction.WEST);
    }
}
