package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro {
	ADXRS450_Gyro Direction;
	public Gyro()
	{	
		Direction = new ADXRS450_Gyro();
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
		//System.out.println("Angle: "+Direction.getAngle());
		return Direction.getAngle();
	}
}
