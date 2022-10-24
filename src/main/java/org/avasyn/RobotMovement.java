package org.avasyn;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.contract.Table;
import java.util.Scanner;

public class RobotMovement {

    public static void main(String[] args )
    {
        RobotMovement toyRobotMovement = new RobotMovement();
        toyRobotMovement.startRobot();
    }

    private void startRobot() {
        //output usage instruction to terminal
        System.out.println("Enter command");
        System.out.println("Format::. 'PLACE X,Y,[NORTH|SOUTH|EAST|WEST]', EXIT, MOVE, RIGHT, LEFT or REPORT");

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
                    System.out.println(outputVal);
                } catch (RobotMovementException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}