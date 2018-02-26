package org.usfirst.frc5459.Protobot54592018.commands;

import org.usfirst.frc5459.Protobot54592018.Robot;
import org.usfirst.frc5459.Protobot54592018.RobotMap;
import org.usfirst.frc5459.Protobot54592018.subsystems.Sensors;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutomaticShift extends Command {

    public AutomaticShift() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shifters);
    	//requires(Robot.sensors);
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//boolean shifterPos = Robot.shifters.getShifters();
    	if( Sensors.GetVelocityY() < 5){
    		if (RobotMap.shiftersShifterSolenoid.get().equals(DoubleSolenoid.Value.kForward)){
    			RobotMap.shiftersShifterSolenoid.set(DoubleSolenoid.Value.kReverse);
    		}
    	}else{
    		if (RobotMap.shiftersShifterSolenoid.get().equals(DoubleSolenoid.Value.kReverse)){
    			RobotMap.shiftersShifterSolenoid.set(DoubleSolenoid.Value.kForward);
    		}

    	}
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
