package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Encoder;

public class EncoderWheel {

	RobotMap r;
	double rotationFactor = 1;
	
	/**
	 * Using the pin numbers as parameters, this contsructor will allow us to create one for all the encoders on the robot.
	 * @param pin
	 * @param otherpin
	 */
	EncoderWheel(int pin, int otherpin){
		/*
		Encoder rotations = new Encoder(pin, otherpin);//This will have to change depending upon the type of encoders we use. Could also potentially change to prox. sensors but same takeaway.
		r = new RobotMap();
		*/
	}
	
	double getCount(){
		//TO DO: Code to do here will get the encoder count.
		double count = 0;
		return count;
	}
	
	public double getDistance(){
		//Using radius and count from above get a final distance to use.
		double distance = getCount()/rotationFactor;
		distance = distance * 0;
		return distance;
	}
}
