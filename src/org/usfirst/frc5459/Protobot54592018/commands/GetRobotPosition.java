
package org.usfirst.frc5459.Protobot54592018.commands;

import java.text.DecimalFormat;

import org.usfirst.frc5459.Protobot54592018.Robot;
import org.usfirst.frc5459.Protobot54592018.RobotMap;
import org.usfirst.frc5459.Protobot54592018.subsystems.Sensors;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.analog.adis16448.frc.*;
/**
 *
 */
public class GetRobotPosition extends Command {
	//X Values
//	double PrevAccelX ;
//	double PrevVelX ;
	double XPosition ;
	double XCalibrationBias ;
//	double DeltaVelocityX;
	double CurrentVelocityX ;
	//Y Values
//	double PrevAccelY ;
//	double PrevVelY ;
	double YPosition ;
	double YCalibrationBias ;
//	double DeltaVelocityY ;
	double CurrentVelocityY;
	
	long PrevTime ;
	
	ADIS16448_IMU bia ;

    public GetRobotPosition() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.sensors);
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	bia = RobotMap.imu ;
    	
    	//X Values
  //  	PrevAccelX = 0.0; 
  //  	PrevVelX = 0.0 ;
    	XPosition = 0.0 ;
    //	DeltaVelocityX = 0;
    	CurrentVelocityX = 0.0 ;
    	
    	//Y Values 
   // 	PrevAccelY = 0.0; 
   // 	PrevVelY = 0.0 ;
    	YPosition = 0.0 ;
    //	DeltaVelocityY = 0 ;
    	CurrentVelocityY = 0 ;
    	
    	PrevTime = System.currentTimeMillis() ;
    	
    	double xAccum = 0 , yAccum = 0 ;
    	
    	for (int i = 0 ; i < 100; i ++){
    	
    	//	xAccum += RobotMap.imu.getAccelX() ;
    	//	yAccum += RobotMap.imu.getAccelY() ;
    		xAccum += bia.getAccelX() ;
    		yAccum += bia.getAccelY() ;
    		
    		try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	XCalibrationBias = xAccum / 100.0 ;
    	
    	YCalibrationBias = yAccum / 100.0 ;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println ("Command executing");
    	
    	
    	// Calculate elapsed time since the last run 
    	long TimeNow = System.currentTimeMillis() ;
    	long ElapsedMS = TimeNow - PrevTime ;
    	double ElapsedSeconds = ((double)ElapsedMS) / 1000.0 ;
   	
    	// Calculate average acceleration.
    	// WPILib reports accelerations in g's. Convert to m/s/s
    	
    	//X CALCULATION
    	double CurrentAccelX = (bia.getAccelX() - XCalibrationBias) * 9.8 ;
    	
    	if(CurrentAccelX < 0.05 && CurrentAccelX > -0.05){
    		CurrentAccelX = 0.0 ;
    	}
    	
    	SmartDashboard.putNumber("X Bias", XCalibrationBias) ;
    	
    	String sX = String.format("%2.3f", CurrentAccelX);
//    	SmartDashboard.putNumber("X Acceleration", CurrentAccelX);
       	SmartDashboard.putString ("X Acceleration", sX);
           	
    	
    	
    	// Calculate change in velocity, based on average acceleration 
    	// over the elapsed time
    	
    	CurrentVelocityX += CurrentAccelX * ElapsedSeconds; 
  
    	// Apply change in velocity to previous velocity, 
    	// producing current velocity
    	
    	
    	String XVel = String.format("%2.3f", CurrentVelocityX);
       	SmartDashboard.putString("X Velocity", XVel) ;
//    	SmartDashboard.putNumber("Current X Velocity", DeltaVelocityX) ;
    	
    	// Calculate average velocity, based on current and previous velocity
    
    	
    	// Calculate change in position by applying average velocity over elapsed time.
    	
    	XPosition += CurrentVelocityX * ElapsedSeconds ;
    	
    	// Calculate Position by applying change to previous position 
    	
    	String XPos = String.format("%2.3f", XPosition);
       	SmartDashboard.putString("X Position str", XPos) ;
//    	SmartDashboard.putNumber("X Position", XPosition) ;
    	// Remember our current acceleration, velocity, and time for next run
    	
    //	PrevVelX = DeltaVelocityX ;
    //	PrevAccelX = CurrentAccelX ;
       	PrevTime = TimeNow ;
       	
       	Sensors.SetPositionX( XPosition);
       	Sensors.SetVelocityX( CurrentVelocityX);
        
       	Robot.GlobalXPosition = this.XPosition;
       	
       	//Y CALCULATION
       	
       	// Calculate average acceleration.
    	// WPILib reports accelerations in g's. Convert to m/s/s
       	//double CurrentAccelY = (RobotMap.imu.getAccelY()  -  YCalibrationBias) * 9.8  ;
       	
       	double CurrentAccelY = (bia.getAccelY() - YCalibrationBias) * 9.8 ;
       	
       	if(CurrentAccelY < 0.05 && CurrentAccelY > -0.05){
    		CurrentAccelY = 0.0 ;
    	}
       	
       	SmartDashboard.putNumber("Y Bias", YCalibrationBias) ;
       	
       	String sY = String.format("%2.3f", CurrentAccelY);
 //   	SmartDashboard.putNumber("Y Acceleration", CurrentAccelY);
       	SmartDashboard.putString ("Y Acceleration str", sY);
       	
       	//double AverageAccelY = (PrevAccelY + CurrentAccelY) / 2 ;
       	
       	// Calculate change in velocity, based on average acceleration 
    	// over the elapsed time
       	
       	CurrentVelocityY += CurrentAccelY * ElapsedSeconds ;
       	
       	// Apply change in velocity to previous velocity, 
    	// producing current velocity
      // 	SmartDashboard.putNumber("Z Accel", bia.getAccelZ())
       	
       	String YVel = String.format("%2.3f", CurrentVelocityY);
       	SmartDashboard.putString("Y Velocity", YVel) ;
//     	SmartDashboard.putNumber("Current Y Velocity", DeltaVelocityY) ;
       	
       	
        // Calculate average velocity, based on current and previous velocity
       	
       	
       	
       	// Calculate change in position by applying average velocity over elapsed time.
       	
       	 
       	
       	// Calculate Position by applying change to previous position
       	
       	YPosition += CurrentVelocityY * ElapsedSeconds ;
       	
       	String YPos = String.format("%2.3f", YPosition);
       	SmartDashboard.putString("Y Position str", YPos) ; 
//       	SmartDashboard.putNumber("Y Position", YPosition) ;
       	
     //  	PrevVelY = DeltaVelocityY ;s
    //	PrevAccelY = CurrentAccelY ;
    	
    	Sensors.SetPositionY(YPosition);
    	Sensors.SetVelocityY(CurrentVelocityY);
    	
    	
       	Robot.GlobalYPosition = this.YPosition;
       	
  //     	String XCurAvgAvvel = "ai" + Double.toString(CurrentAccelX) +"Aavg" + Double.toString(AverageAccelX) ;
  //     	String XCurAvgVel = "vi" + Double.toString(CurrentVelocityX) + "Vavg" + Double.toString(AverageVelocityX) ;
       	
   //    	String YCurAvgAccel = "ElapsedSec:" + Double.toString(ElapsedSeconds) + " ai:" + Double.toString(CurrentAccelY) + "Aavg:" + Double.toString(AverageAccelY) ;
   //    	String YCurAvgVel = "DV: " + Double.toString(DeltaVelocityY)+ " vi" + Double.toString(CurrentVelocityY) + "Vavg" + Double.toString(AverageVelocityY) ;
   //    	String YCurDeltaPos = "DP:" + Double.toString(DeltaYPosition) + " Pos:" + Double.toString(YPosition) + "\n";
       	
     //  	System.out.printf(YCurAvgAccel + YCurAvgVel + YCurDeltaPos) ;
       	
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

