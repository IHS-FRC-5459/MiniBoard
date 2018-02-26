package org.usfirst.frc5459.Protobot54592018.subsystems;

import org.usfirst.frc5459.Protobot54592018.Robot;
import org.usfirst.frc5459.Protobot54592018.RobotMap;
import org.usfirst.frc5459.Protobot54592018.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ManipulatorOuttake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 
//	    private final WPI_TalonSRX manipulatorTalon5 = RobotMap.rampTalon5;
//	    private final WPI_TalonSRX manipulatorTalon6 = RobotMap.rampTalon6;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new DriveCommand());
    	
    }
  
    
    public void periodic() {
    	
    }
    
    public void outtakeSet (double powerIn){
//    	RobotMap.rampTalon5.set(powerIn);
//   	RobotMap.rampTalon6.set(powerIn*-1);
    	
    	
    	
    	
    	
    }
    }

