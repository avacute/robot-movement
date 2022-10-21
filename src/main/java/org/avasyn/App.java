package org.avasyn;

import org.avasyn.exception.ToyRobotMovementException;
import org.avasyn.simulation.Simulation;
import org.avasyn.simulation.SquareTable;
import org.avasyn.simulation.ToyRobot;
import org.avasyn.simulation.contract.Table;
import java.util.Scanner;

public class App {
    public static void main( String[] args )
    {
        Scanner nn = new Scanner(System.in);

        Table squareTable = new SquareTable(5, 5);
        ToyRobot toyRobot = new ToyRobot();
        Simulation simulation = new Simulation(squareTable, toyRobot);
        System.out.println("Enter command in of the format Below");
        System.out.println("'PLACE X,Y,NORTH|SOUTH|EAST|WEST', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = nn.nextLine();
            if ("EXIT".equals(inputString)) {
                keepRunning = false;
            } else {
                try {
                    String outputVal = simulation.robotMovement(inputString);
                    System.out.println(outputVal);
                } catch (ToyRobotMovementException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
