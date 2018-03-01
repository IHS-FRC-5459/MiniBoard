package org.usfirst.frc5459.Protobot54592018.subsystems;

import org.usfirst.frc5459.Protobot54592018.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestSpark extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final Spark spark = RobotMap.barMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void sparkOn (){
    	spark.set(1.0);
    }
    public void sparkOff (){
    	spark.set(0.0);
    }
}

