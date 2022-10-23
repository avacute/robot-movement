package org.avasyn.simulation.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.util.CardinalDirection;

public interface RobotPosition {
    int getXCoordinate();

    int getYCoordinate();

    CardinalDirection getDirection();

    void setDirection(CardinalDirection cardinalDirection);

    void stepRobotPosition(int x, int y);

    ToyRobotPosition changeRobotPosition() throws RobotMovementException;
}
