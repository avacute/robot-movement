package org.avasyn.command.contract;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.ToyRobot;

public interface SendCommand {

    public String sendCommand(ToyRobotPosition toyRobotPosition, Simulation simulation, ToyRobot toyRobot) throws RobotMovementException;
}
