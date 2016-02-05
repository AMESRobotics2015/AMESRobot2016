package org.usfirst.frc.team3243.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * This class contains all the methods having to do with: cameras and gyro.
 * @author markvandermerwe
 *
 */
public class Sensors {
	//protected static USBCamera watch;
	protected static CameraServer camera;
	protected static CameraServer cameraBack;
	ADXRS450_Gyro Direction;
	private static final String[] GRIP_ARGS = new String[] {//Move camera stuff to sensors class.
	    	"/usr/local/frc/JRE/bin/java","-jar","/home/lvuser/grip.jar",
	    	"/home/lvuser/FindBoulder.grip"
	    };
	private final NetworkTable grip = NetworkTable.getTable("grip");
	
	/**
	 * Constructor to set up our various sensors.
	 */
	public Sensors (boolean camcam)
	{
		camera = CameraServer.getInstance();
		camera.setQuality(50);
		cameraBack = CameraServer.getInstance();
		cameraBack.setQuality(50);
		Direction = new ADXRS450_Gyro();
		Direction.calibrate();
		
		try{
        	Runtime.getRuntime().exec(GRIP_ARGS);
        }
        catch (IOException e){
        	e.printStackTrace();
        }
	}
	
	/**
	 * This method will get the feedback from the gyro to be used elswhere.
	 */
	
	public void cam(boolean camon){
		
	}
	
	public double gyroFeed(boolean reset){
		//getAngle method returns a value between negative infinity and infinity representing the deviation in degrees from the angle 0
		//for example, if turn the gyro two full turns to the left, it will return (-720). 
		
		if (reset)
		{
			Direction.reset();
		}
		//System.out.println("Direction Center: " + Direction.getCenter());
		//System.out.println("Current Angle: " + Direction.getAngle());
		System.out.println( Direction.getAngle());
		/*
		if (128 < Direction.getAngle() && Direction.getAngle()< 132)
		{
		System.out.println( "DONE");
		}
		*/
		return Direction.getAngle();
	}
	
	public void switchCam(int Front)
	{
		
		if(Front % 2== 0){	
			camera.startAutomaticCapture("cam2");
		}
		if(Front % 2 == 1) 
		{
			cameraBack.startAutomaticCapture("cam1");
		}
	}
	
	
}
