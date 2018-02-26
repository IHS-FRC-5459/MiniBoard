package org.usfirst.frc5459.Protobot54592018.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
	import org.usfirst.frc5459.Protobot54592018.Robot;
	import org.usfirst.frc5459.Protobot54592018.RobotMap;
	import org.usfirst.frc5459.Protobot54592018.subsystems.ManipulatorIntake;

public class IntakeOut extends Command {
	
	public IntakeOut(){
		requires(Robot.manipulatorIntake);
	}
		
			  
		    @Override
		    protected void initialize() {
		    	
		    }

		   
		    @Override
		    protected void execute() {
		    	
//		    	double powerIn = Robot.oi.O3.getY(Hand.kLeft);
//		    	Robot.manipulatorOuttake.outtakeSet(powerIn);
		    	//Robot.manipulatorIntake.intakeOut();
		    	//Robot.manipulatorIntake.barBack();
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


