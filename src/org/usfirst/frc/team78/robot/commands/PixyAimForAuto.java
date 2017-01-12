package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.subsystems.Chassis;
import org.usfirst.frc.team78.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PixyAimForAuto extends Command {

	double speed;
	double scale = 0.02;
	boolean isFin = false;
	int count;
	
	public Timer timer = new Timer();
	
    public PixyAimForAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	requires(Robot.vision);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		timer.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    
    	
        	if(Vision.xPosition > 190){
        		speed = (Vision.xPosition - 180) * scale;
        		Robot.chassis.setSpeed(speed, -speed);
        		//timer.reset();
        	}else if(Vision.xPosition < 160){
        		speed = (160 - Vision.xPosition) * scale;
        		Robot.chassis.setSpeed(-speed, speed);
        		//timer.reset();
        	}else{
        		Robot.chassis.stopAllDrive();
        		timer.start();
        		
        		count++;
        	}
        	
        	if(count >= 20){
        		isFin = true;
        	}
       	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFin;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stopAllDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.stopAllDrive();

    }
}
