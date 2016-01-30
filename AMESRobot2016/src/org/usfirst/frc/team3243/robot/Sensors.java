package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.AnalogGyro;

/**
 * This class contains all the methods having to do with: cameras and gyro.
 * @author markvandermerwe
 *
 */
public class Sensors {
	//protected static USBCamera watch;
	protected static CameraServer camera;
	protected static AnalogGyro Direction;
	/**
	 * Constructor to set up our various sensors.
	 */
	public Sensors ()
	{
		//camera = CameraServer.getInstance();
		//watch = new USBCamera();
		
		Direction = new AnalogGyro(1);
		Direction.initGyro();
		Direction.calibrate();
		
	}
	
	/**
	 * Starts up the usb camera for the driver to see with.
	 */
	public void startCamera()
	{
		camera.setQuality(50);
		camera.startAutomaticCapture("cam1");
	}
	
	/**
	 * This method will get the feedback from the gyro to be used elswhere.
	 */
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
		if (128 < Direction.getAngle() && Direction.getAngle()< 132)
		{
		System.out.println( "DONE");
		}
		
		double x = 0;
		return x;
		
	}
	
	/**
	 * BEN PUT YOUR VISION GRIP STUFF HERE.
	 */
	public void vision(){
		
	}
	
}
