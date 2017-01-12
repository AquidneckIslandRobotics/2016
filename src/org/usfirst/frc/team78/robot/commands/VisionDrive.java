package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDrive extends Command {

	double leftSpeed;
	double rightSpeed;
	double startHeading;
	
    public VisionDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startHeading = Robot.chassis.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftSpeed = Robot.chassis.visionTurn();
    	rightSpeed = leftSpeed;
    	
    	leftSpeed = leftSpeed + Robot.chassis.headingCorrection(startHeading);
    	rightSpeed = rightSpeed - Robot.chassis.headingCorrection(startHeading);
    	
    	Robot.chassis.setSpeed(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.chassis.isAtVisionDistance();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stopAllDrive();
    	Robot.chassis.timerStart = false;
    	Robot.chassis.atTarget = false;
    	Robot.chassis.timer.stop();
    	Robot.chassis.timer.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
