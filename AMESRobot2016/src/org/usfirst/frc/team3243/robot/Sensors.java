package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Sensors {
	protected static USBCamera watch;
	public Sensors ()
	{
		USBCamera watch = new USBCamera();
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
}
