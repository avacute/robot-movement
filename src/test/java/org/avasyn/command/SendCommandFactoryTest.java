package org.avasyn.command;

import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.ToyRobotPosition;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.RobotPosition;
import org.avasyn.simulation.contract.Table;
import org.avasyn.util.CardinalDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendCommandFactoryTest {

    @Test
    public void testSendPlaceCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0,CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);
        SendCommandFactory sendCommandFactory = new SendCommandFactory();
        assertEquals("Robot placed on Table",sendCommandFactory.executeCommand(
                Command.PLACE,0,0,CardinalDirection.NORTH,toyRobot,simulation
        ));
    }



    @Test
    public void testSendMoveCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0,CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);
        SendCommandFactory sendCommandFactory = new SendCommandFactory();
        assertEquals("Robot move towards NORTH",sendCommandFactory.executeCommand(
                Command.MOVE,0,0,CardinalDirection.NORTH,toyRobot,simulation
        ));
    }


    @Test
    public void testSendLeftCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0,CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);
        SendCommandFactory sendCommandFactory = new SendCommandFactory();
        assertEquals("Robot turned Left: WEST",sendCommandFactory.executeCommand(
                Command.LEFT,0,0,CardinalDirection.NORTH,toyRobot,simulation
        ));
    }


    @Test
    public void testSendRightCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0,CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);
        SendCommandFactory sendCommandFactory = new SendCommandFactory();
        assertEquals("Robot turned Right: EAST",sendCommandFactory.executeCommand(
                Command.RIGHT,0,0,CardinalDirection.NORTH,toyRobot,simulation
        ));
    }

    @Test
    public void testSendReportCommand() throws Exception{
        RobotPosition toyRobotPosition = new ToyRobotPosition(0, 0,CardinalDirection.NORTH);
        Robot toyRobot = new ToyRobot(toyRobotPosition);
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);
        SendCommandFactory sendCommandFactory = new SendCommandFactory();
        assertEquals("0,0,NORTH",sendCommandFactory.executeCommand(
                Command.REPORT,0,0,CardinalDirection.NORTH,toyRobot,simulation
        ));
    }


}
