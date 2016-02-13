package org.usfirst.frc.team3243.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Drive - Done. Finished on 2/1/16
 * Ball handling - test. Finish by 2/5/16
 * Camera - Done. Finish by 2/1/16
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
    RobotMap RM;
    EncoderWheel EW;
    EncoderWheel EWA;
    AStarPathfinding AS;
    GameArm GA;
    Gyro G;
    Auto A;
    Grabber GB;
    CameraServer cam;
    //Grabber G;
    double degree = 90;
    double distance;
    String camx;
    //Pathfinding
    double[] path;
    int pathStep;
    boolean pathRunning;
    boolean change;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        
        cam = CameraServer.getInstance();
        cam.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        cam.startAutomaticCapture("cam0");
        
        IM = new InputManager();
        EW = new EncoderWheel(1,2);
        EWA = new EncoderWheel(3,4);
        G = new Gyro();
        DS = new DriveSystem(EW, EWA, false);
        RM = new RobotMap();
        AS = new AStarPathfinding();
        GA = new GameArm();
        A = new Auto(DS,G);
        GB = new Grabber();
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
		A.step=0;
		G.gyroFeed(true);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
    		//Put custom auto code here   
    		break;
    	case defaultAuto:
    	    default:
    	    //Get info here once per iteration.
    	    //Get step we're on and check if we need to move on.
    	    A.Step();
    	    A.stepNum();
    	    //Do it.
    	    if(A.stepNum()<3){
    	    	DS.quickdrive(A.Step());
    	    }else{
    	    	//System.out.println("Nope");
    	    	DS.stop();
    	    }
    	    
    	    //Put default auto code here
    	    break;
    	    }
    }

    /**
     * This function is called periodically during operator control
     * Press the y button to reset the gyro value; in other words, set the direction the robot is currently facing as 0
     * */
    public void teleopPeriodic() {
    	//DS.quickdrive(IM.input());
    	DS.drive(IM.input());
    	GB.pullIn(IM);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	if(IM.move.getRawButton(7)){
    		if(change){
    			change = false;
    		}else if(!change){
    			change = true;
    		}
    	}
    	if(change){
    		camx = "cam1";
    	}else if(!change){
    		camx = "cam2";
    	}
    	cam.startAutomaticCapture(camx);
    }
    
}