package org.avasyn.command;

import org.avasyn.command.contract.SendPlaceCommand;
import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;


public class PlaceCommand implements SendPlaceCommand {

    @Override
    public String sendCommand(Table squareTable, RobotPosition toyRobotPosition, Simulation simulation) throws RobotMovementException {

      return String.valueOf(simulation.placeRobotTable(toyRobotPosition,squareTable));

    }
}
