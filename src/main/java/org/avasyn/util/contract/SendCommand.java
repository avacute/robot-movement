package org.avasyn.util.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.RobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;

public interface SendCommand {

    public String sendCommand(RobotPosition robotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException;
}
