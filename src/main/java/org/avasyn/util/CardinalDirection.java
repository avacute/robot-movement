package org.avasyn.util;

import java.util.HashMap;
import java.util.Map;

public enum CardinalDirection {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private static Map<Integer, CardinalDirection> directionMap = new HashMap<Integer, CardinalDirection>();
    private int directionIndex;

    static {
        for (CardinalDirection cardinalDirectionEnum : CardinalDirection.values()) {
            directionMap.put(cardinalDirectionEnum.directionIndex, cardinalDirectionEnum);
        }
    }


    private CardinalDirection(int direction) {
        this.directionIndex = direction;
    }

    public static CardinalDirection valueOf(int directionNum) {
        return directionMap.get(directionNum);
    }

    // returns the direction on the left of the current one
    public CardinalDirection leftDirection() {
        return rotate(-1);
    }


    // returns the direction on the right of the current one
    public CardinalDirection rightDirection() {
        return rotate(1);
    }

    private CardinalDirection rotate(int turn) {

        int newDirectionIndex = (this.directionIndex + turn) < 0 ? directionMap.size() - 1 :
                (this.directionIndex + turn) % directionMap.size();

        return CardinalDirection.valueOf(newDirectionIndex);
    }
}
