package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {

    public Intake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double speed = Robot.oi.getManipulatorStick();
    	Robot.intake.setIntakeSpeed(-0.5);
    	Robot.shooter.setShooterSpeed(-0.35);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//!Robot.oi.isStickPushed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setIntakeSpeed(0);
    	Robot.shooter.setShooterSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
