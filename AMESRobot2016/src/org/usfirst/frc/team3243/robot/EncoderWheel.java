package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class EncoderWheel {

	RobotMap r;
	Counter rotations;
	double rotationFactor = 1;
	
	/**
	 * Using the pin numbers as parameters, this contsructor will allow us to create one for all the encoders on the robot.
	 * @param pin
	 * @param otherpin
	 */
	EncoderWheel(int pin){
		
		rotations = new Counter(pin);//This will have to change depending upon the type of encoders we use. Could also potentially change to prox. sensors but same takeaway.
		
	}
	
	public double getCount(boolean reset){
		if(reset){
			rotations.reset();
		}
		double count = rotations.get();
		System.out.println(count);
		return count;
	}
	
	public double getDistance(){
		//Using radius and count from above get a final distance to use.
		//double distance = getCount(false)/rotationFactor;
		double distance = 0;
		return distance;
	}
}
