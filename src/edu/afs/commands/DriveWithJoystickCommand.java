/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.afs.commands;

import edu.afs.subsystems.drivesubsystem.*;
/**
 *
 * @author User
 */
public class DriveWithJoystickCommand extends CommandBase {
    
    
    public DriveWithJoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive); // reserve the chassis subsystem
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.driveWithJoystick();
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
