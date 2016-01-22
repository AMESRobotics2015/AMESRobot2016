package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * This class contains all the classes having to do with the various sensors (camera, encoder, accelerometer, etc.) we might end up using.
 * @author markvandermerwe
 *
 */
public class Sensors {
	protected static USBCamera watch;
	protected static Encoder Rotations;
	
	/**
	 * Constructor to set up our various sensors.
	 */
	public Sensors ()
	{
		USBCamera watch = new USBCamera();
		Encoder Rotations  = new Encoder(null, null);
	}
	
	/**
	 * Starts up the usb camera for the driver to see with.
	 */
	public void startCamera()
	{
		Timer watchFor = new Timer();
		do
		{
		watch.openCamera();
		watch.startCapture();
		
		watchFor.start();
		}
		while (watchFor.get()< 20);
		watch.stopCapture();
		//cam.
	}
	
	/**
	 * This method ONLY READS THE ENCODER count.
	 * @param cycles
	 * @return
	 */
	public boolean encoderCount(double cycles)
	{
		//As per the javadoc comment above, this needs to be altered slightly.
		Rotations.reset();
		while(Rotations.get() < cycles)
		{
			System.out.println(Rotations.get());
		return false;
		}
		return true;
	}
	
	/**
	 * This method will get the feedback from the gyro to be used elswhere.
	 */
	public void gyroFeed(){
		//Put code here - will have to change the return and possibly params.
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
