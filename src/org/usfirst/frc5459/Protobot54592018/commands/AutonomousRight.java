//package org.usfirst.frc5459.Protobot54592018.commands;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.CommandGroup;
//
///**
// *
// */
//public class AutonomousRight extends CommandGroup {
//
//    public AutonomousRight() {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	
//    	String gameData;
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
//                if(gameData.length() > 0)
//                {
//                	if(gameData.charAt(0) == 'L')
//                	{
//			//Put left auto code here
//                		addSequential(new DrivePID(229));
//                		addSequential(new TurnTo(270));
//                		addSequential(new DrivePID(159));
//                		addSequential(new TurnTo(90));
//                		addSequential(new DrivePID(-14));
//                		addSequential(new OutakeOut());
//                	} else {
//			//Put right auto code here
//                		addSequential(new DrivePID(168));
//                		addSequential(new TurnTo(90));	
//                		addSequential(new DrivePID(-18));
//                		addSequential(new OutakeOut());
//                		
//                	}
//                	
//                }
//    	
//    	
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
