package org.usfirst.frc5459.Protobot54592018.commands;

import org.usfirst.frc5459.Protobot54592018.OI;
import org.usfirst.frc5459.Protobot54592018.Robot;
import org.usfirst.frc5459.Protobot54592018.RobotMap;
import org.usfirst.frc5459.Protobot54592018.subsystems.Drive;
import org.usfirst.frc5459.Protobot54592018.subsystems.ManipulatorIntake;
import org.usfirst.frc5459.Protobot54592018.subsystems.ManipulatorOuttake;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID.Hand;


public class DriveCommand extends Command {

	public DriveCommand() {
		

		requires(Robot.drive);
		requires(Robot.manipulatorIntake);
		requires(Robot.manipulatorOuttake);
		
		
		
		
	}
	
	protected void initialize() {
	
	}
	
	protected void execute() {

		
		//RobotMap.driveLeftGroup.set(Robot.oi.O1.getY()*-1);
		//RobotMap.driveRightGroup.set(Robot.oi.O2.getY());
		/*
		System.out.println("Executing");
		double leftPower = (Robot.oi.O1.getY());
		double editLeftPower =  Math.pow(leftPower, 3);
		double rightPower = (Robot.oi.O2.getY());
		double editRightPower =  Math.pow(rightPower, 3);
		RobotMap.driveLeftGroup.set(editLeftPower*-1);
		RobotMap.driveRightGroup.set(editRightPower);
	
		//Robot.manipulatorIntake.intakeSet(Robot.oi.O3.getY(Hand.kLeft));
		Robot.manipulatorOuttake.outtakeSet(Robot.oi.O3.getY(Hand.kLeft) *0.25);
		*/
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void interupted(){
		
	}
	protected void end(){
		System.out.println("Ending");
		RobotMap.driveLeftGroup.set(0);
		RobotMap.driveRightGroup.set(0);
		//Robot.manipulatorIntake.intakeSet(0);
		Robot.manipulatorOuttake.outtakeSet(0);
	}
	
}
