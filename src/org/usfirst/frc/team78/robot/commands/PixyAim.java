package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.subsystems.Chassis;
import org.usfirst.frc.team78.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PixyAim extends Command {

	double speed;
	double scale = 0.01;
	
    public PixyAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
        	if(Vision.xPosition > 175){
        		speed = (Vision.xPosition - 175) * scale;
        		Robot.chassis.setSpeed(speed, -speed);
        	}else if(Vision.xPosition < 160){
        		speed = (160 - Vision.xPosition) * scale;
        		Robot.chassis.setSpeed(-speed, speed);
        	}else{
        		Robot.chassis.stopAllDrive();
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
