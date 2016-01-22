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
		Timer Josh = new Timer();
		do
		{
		watch.openCamera();
		watch.startCapture();
		
		Josh.start();
		}
		while (Josh.get()< 20);
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
		Rotations.reset();
		while(Rotations.get() < cycles)
		{
			System.out.println(Rotations.get());
		return false;
		}
		return true;
	}
}
