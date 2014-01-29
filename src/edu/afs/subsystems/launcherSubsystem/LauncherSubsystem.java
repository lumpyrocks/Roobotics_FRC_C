/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.afs.subsystems.launcherSubsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.afs.robot.RobotMap;

/**
 *
 * @author User
 */
public class LauncherSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //TODO: Determine thresholds on launcher hardware.
    private static final int UPPER_MOTOR_CUTOFF_THRESHOLD = 400;
    private static final int LOWER_MOTOR_CUTOFF_THRESHOLD = 20;
    private static final double LOW_SPEED_SCALE_FACTOR = 0.1;
    private static final double MEDIUM_SPEED_SCALE_FACTOR = 0.5;
    private static final double HIGH_SPEED_SCALE_FACTOR = 1.0;
    
    static LauncherSubsystem instance = null;
    Victor m_leftMotor;
    Victor m_rightMotor;   
    Encoder m_launcherEncoder;
      
    public static LauncherSubsystem getInstance () {
        if (instance == null) {
            instance = new LauncherSubsystem();
        }
        return instance;
    }
    
    private LauncherSubsystem () {
        
        m_leftMotor = new Victor(RobotMap.LAUNCHER_LEFT_MOTOR_CHANNEL);
        m_rightMotor = new Victor(RobotMap.LAUNCHER_RIGHT_MOTOR_CHANNEL);
        m_launcherEncoder = new Encoder(RobotMap.LAUNCHER_ENCODER_MODULE,
                                        RobotMap.LAUNCHER_ENCODER_A_CHANNEL,
                                        RobotMap.LAUNCHER_ENCODER_MODULE,
                                        RobotMap.LAUNCHER_ENCODER_B_CHANNEL,
                                        false);
        
        // Assume launcher starts in reset position. Set encoder count to zero.
        m_launcherEncoder.reset();
        // Start encoder count.
        m_launcherEncoder.start();
        resetLauncher();  
    }
    
    public void fireLauncher(){
        if(m_launcherEncoder.get() <= UPPER_MOTOR_CUTOFF_THRESHOLD){
            //TODO: Determine motor speed on both launcher motors - ramp up.
            //m_leftMotor.set(??????);
           // m_rightMotor.set(???????); 
        } 
    }
    
    public void resetLauncher(){
        if(m_launcherEncoder.get() >= LOWER_MOTOR_CUTOFF_THRESHOLD){
            //TODO: Determine motor speed on both launcher motors - ramp up.
            //m_leftMotor.set(??????);
            // m_rightMotor.set(???????); 
        } 
        
    }
    
    public int getLauncherPosition(){
       return m_launcherEncoder.get();
    }

    public void initDefaultCommand() {
        //TODO:Send launcher position to OI.
    }
}
