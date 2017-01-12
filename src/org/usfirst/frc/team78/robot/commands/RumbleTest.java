package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.OI;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RumbleTest extends Command {

	float m_i;
	
    public RumbleTest(float i) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_i = i;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	OI.tStick.setRumble(RumbleType.kLeftRumble, m_i);
    	OI.tStick.setRumble(RumbleType.kRightRumble, m_i);
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
