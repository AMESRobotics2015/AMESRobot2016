
package org.usfirst.frc.team3243.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Drive - Done. Finished on 2/1/16
 * Ball handling - test. Finish by 2/5/16
 * Camera - fix. Finish by 2/1/16
 * Arm - need to do. 2/5/16 (tentative)
 * Climber - need to do. 2/5/16 (tentative)
 * Auto - Gyro - fix for new (2/3/16) + Encoders (2/7/16) test. Also create grabber code for auto (2/6/15).
 * Pathfinding integration - (2/9/16)
 */

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    InputManager IM;
    DriveSystem DS;
    Sensors S;
    RobotMap RM;
    EncoderWheel EW;
    EncoderWheel EWA;
    AStarPathfinding AS;
    //Grabber G;
    double degree;
    double distance;
    
    //Pathfinding
    double[] path;
    int pathStep;
    boolean pathRunning;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        IM = new InputManager();
        EW = new EncoderWheel(1,2);
        EWA = new EncoderWheel(3,4);
        S = new Sensors(true);
        DS = new DriveSystem(S, EW, EWA, true);
        RM = new RobotMap();
        AS = new AStarPathfinding();
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
		pathStep = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	DS.autoDrive(AS.start());
    	//grip.getNumberArray("FindBoulder/area",double[]) to get contour areas
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    		DS.moveDistance(5);
    		DS.rotate(20);
    		
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     * Press the y button to reset the gyro value; in other words, set the direction the robot is currently facing as 0
     * */
    public void teleopPeriodic() {
    	DS.drive(IM.input());
    	S.gyroFeed(IM.move.getRawButton(4));
    	EW.getCount(false);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
