package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntake extends Command {

	String m_direction;
	
    public MoveIntake(String direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake); //TODO may have to remove this or move the pneumatics and motors into different subsystems
    	m_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(m_direction == "down"){
    		Robot.intake.intakeDown();
    	}
    	else if(m_direction == "up"){
    		Robot.intake.intakeUp();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
