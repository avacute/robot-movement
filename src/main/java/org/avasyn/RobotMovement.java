package org.avasyn;

import org.avasyn.exception.RobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.contract.Robot;
import org.avasyn.simulation.contract.Table;
import java.util.Scanner;

public class RobotMovement {

    public static void main(String[] args )
    {
        RobotMovement toyRobotMovement = new RobotMovement();

        // create objects
        Scanner inputPane = new Scanner(System.in);
        Robot toyRobot = new ToyRobot();
        Table squareTable = new SquareTable(5, 5);
        Simulation simulation = new Simulation(squareTable, toyRobot);

        toyRobotMovement.startRobot(simulation,inputPane,toyRobot,squareTable);
    }

    private void startRobot( Simulation simulation,Scanner inputPane,Robot toyRobot,Table squareTable) {
        //output usage instruction to console
        System.out.println("Enter command in the format Below");
        System.out.println("'PLACE X,Y,[NORTH|SOUTH|EAST|WEST]', EXIT, MOVE, RIGHT, LEFT or REPORT");

        inputPane = new Scanner(System.in);
        toyRobot = new ToyRobot();
        squareTable = new SquareTable(5, 5);
        simulation = new Simulation(squareTable, toyRobot);
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