package org.usfirst.frc5459.Protobot54592018.commands;

import org.usfirst.frc5459.Protobot54592018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SparkOn extends Command {

    public SparkOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.testSpark);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.testSpark.sparkOn();
    	System.out.println("spark on executing");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.testSpark.sparkOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
