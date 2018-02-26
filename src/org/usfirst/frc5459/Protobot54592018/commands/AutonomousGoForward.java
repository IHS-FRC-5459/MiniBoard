package org.usfirst.frc5459.Protobot54592018.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGoForward extends CommandGroup {

    public AutonomousGoForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double TargetPos;
    	double Position;
    	
    	//Position = GetPositionX.
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
                		addSequential(new DrivePID(300));
                
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
