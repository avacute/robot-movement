package org.avasyn;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.contract.Table;
import java.util.Scanner;
import java.util.logging.Logger;

public class RobotMovement {

    private static final Logger LOGGER = Logger.getLogger("Start project");
    public static void main(String[] args )
    {
        RobotMovement toyRobotMovement = new RobotMovement();
        toyRobotMovement.startRobot();
    }

    private void startRobot() {
        //output usage instruction to console
        LOGGER.info("Enter command in the format Below");
        LOGGER.info("'PLACE X,Y,[NORTH|SOUTH|EAST|WEST]', EXIT, MOVE, RIGHT, LEFT or REPORT");


        // create objects
        Scanner inputPane = new Scanner(System.in);
        ToyRobot toyRobot = new ToyRobot();
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);

        boolean isRunning = true;
        while (isRunning) {
            String inputString = inputPane.nextLine();
            if ("EXIT".equals(inputString))
                isRunning = false;
            else {
                try {
                    String outputVal = simulation.robotMovement(inputString);
                    LOGGER.info(outputVal);
                } catch (RobotMovementException e) {
                    LOGGER.warning(e.getMessage());
                }
            }
        }
    }
}