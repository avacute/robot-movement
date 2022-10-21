package org.avasyn.util;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private static Map<Integer, Direction> directionMap = new HashMap<Integer, Direction>();
    private int directionIndex;

    static {
        for (Direction directionEnum : Direction.values()) {
            directionMap.put(directionEnum.directionIndex, directionEnum);
        }
    }


    private Direction(int direction) {
        this.directionIndex = direction;
    }

    public static Direction valueOf(int directionNum) {
        return directionMap.get(directionNum);
    }

    // returns the direction on the left of the current one
    public Direction leftDirection() {
        return rotate(-1);
    }


    // returns the direction on the right of the current one
    public Direction rightDirection() {
        return rotate(1);
    }

    private Direction rotate(int turn) {

        int newDirectionIndex = (this.directionIndex + turn) < 0 ? directionMap.size() - 1 :
                (this.directionIndex + turn) % directionMap.size();

        return Direction.valueOf(newDirectionIndex);
    }
}
