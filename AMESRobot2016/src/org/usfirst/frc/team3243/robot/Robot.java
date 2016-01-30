
package org.usfirst.frc.team3243.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    double degree;
    double distance;
    private static final String[] GRIP_ARGS = new String[] {//Move camera stuff to sensors class.
    	"/usr/local/frc/JRE/bin/java","-jar","/home/lvuser/grip.jar",
    	"/home/lvuser/FindBoulder.grip"
    };
    private final NetworkTable grip = NetworkTable.getTable("grip");
	
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
        DS = new DriveSystem();
        S = new Sensors();
        RM = new RobotMap();
        try{
        	Runtime.getRuntime().exec(GRIP_ARGS);
        }
        catch (IOException e){
        	e.printStackTrace();
        }
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
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
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
    	//S.startCamera();
    	DS.drive(IM.input());
    	S.gyroFeed(IM.move.getRawButton(4));
    	
    	/*
    	int ballDir = (IM.move.getRawButton(1)?DriveSystem.CARRY_IN:DriveSystem.CARRY_STOP);
    	if (IM.move.getRawButton(2)) {
    		if (ballDir == DS.CARRY_IN) {
    			ballDir = DS.CARRY_STOP;
    		}
    		else {
    			ballDir = DS.CARRY_OUT;
    		}
    	}
    	DS.ballCarrier(ballDir);//Move the Input stuff to InputManager and the Motor stuff to Grabber class.
    	*/
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
