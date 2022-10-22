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

        /*
         Let use leftDirection as example starting from WEST (3)
         Note the length of the map is 4 => directionMap.size() - 1 = 3

         LeftDirection minus  1 from the current index

        STEP 1: (3-1) < 0 ? 3 : ((3-1) % 4) => 2 < 0 ? 3 : 2 => 2 is not less than 0 then newDirectionIndex is 2 - SOUTH
        STEP 2: (2-1) < 0 ? 3 : ((2-1) % 4) => 1 < 0 ? 3 : 1 => 1 is not less than 0 then newDirectionIndex is 1 - EAST
        STEP 3: (1-1) < 0 ? 3 : ((1-1) % 4) => 0 < 0 ? 3 : 0 => 0 is not less than 0 then newDirectionIndex is 0 - NORTH
        STEP 4: (0-1) < 0 ? 3 : ((0-1) % 4) => -1 < 0 ? 3 : -1  => -1 is less than 0 the newDirectionIndex is 3 - WEST

         */

        int newDirectionIndex = (this.directionIndex + turn) < 0 ? directionMap.size() - 1 :
                (this.directionIndex + turn) % directionMap.size();

        return CardinalDirection.valueOf(newDirectionIndex);
    }
}
