package org.usfirst.frc5459.Protobot54592018.commands;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5459.Protobot54592018.Robot;
import org.usfirst.frc5459.Protobot54592018.RobotMap;
import org.usfirst.frc5459.Protobot54592018.subsystems.ManipulatorIntake;
import edu.wpi.first.wpilibj.GenericHID.Hand;


public class IntakeIn  extends Command {
	public IntakeIn(){
		requires(Robot.manipulatorIntake);
		requires(Robot.manipulatorOuttake);
	}
	
 
	    @Override
	    protected void initialize() {
	    	
	    }

	   
	    @Override
	    protected void execute() {
	    	
//	    	double powerIn = Robot.oi.O3.getY(Hand.kLeft);
	    	//Robot.manipulatorIntake.intakeIn();
//	    	Robot.manipulatorOuttake.outtakeSet(powerIn);
	    	//Robot.manipulatorIntake.barOn();
	    }

	 
	    @Override
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    @Override
	    protected void end() {
	    	//Robot.manipulatorIntake.intakeOff();
	    	//Robot.manipulatorIntake.barOff();
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    @Override
	    protected void interrupted() {
	    }
	
}
