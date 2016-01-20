package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Sensors {
	protected static USBCamera watch;
	protected static Encoder Rotations;
	public Sensors ()
	{
		USBCamera watch = new USBCamera();
		Encoder Rotations  = new Encoder(null, null);
	}
	public void startJoshFace()
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
