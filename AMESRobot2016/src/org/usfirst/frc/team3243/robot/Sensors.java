package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.AnalogGyro;

/**
 * This class contains all the classes having to do with the various sensors (camera, encoder, accelerometer, etc.) we might end up using.
 * @author markvandermerwe
 *
 */
public class Sensors {
	protected static USBCamera watch;
	protected static Encoder Rotations;
	protected static AnalogGyro Direction;
	protected static CameraServer camera;
	/**
	 * Constructor to set up our various sensors.
	 */
	public Sensors ()
	{
	
		watch = new USBCamera();
		// Rotations  = new Encoder(null, null);
		Direction = new AnalogGyro(0);
		Direction.initGyro();
		Direction.calibrate();
	}
	
	/**
	 * Starts up the usb camera for the driver to see with.
	 */
	public void startCamera()
	{
		camera.setQuality(50);
		camera.startAutomaticCapture();
	}
	
	/**
	 * This method ONLY READS THE ENCODER count.
	 * @param cycles
	 * @return
	 */
	public double encoderCount()
	{
		double num = 0;//Use this as the # encoder count.
		//As per the javadoc comment above, this needs to be altered slightly.
		Rotations.reset();
		Rotations.get();
		return num;
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
		return Direction.getAngle();
	}
	
	/**
	 * Not sure we'll need this but its here in case - this method will allow us to get information from camera hooked up - this is vision processing.
	 */
	public void vision(){
		
	}
	
	/**
	 * This method will take input from the encoders and use it to correct the movement to what it should actually be.
	 */
	public void correction(){
		
	}
}
