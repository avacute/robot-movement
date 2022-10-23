package org.avasyn.simulation.contract;

public interface Robot {
    public String turnRight();
    public String turnLeft();
    public String moveRobot(RobotPosition toyRobotPosition);
    public String setRobotPosition(RobotPosition toyRobotPosition);
    public RobotPosition getRobotPosition();
}
