package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class EncoderWheel {
	RobotMap r;

	
	/**
	 * Using the pin numbers as parameters, this constructor will allow us to create one for all the encoders on the robot.
	 * @param pin
	 * @param otherpin
	 */
	EncoderWheel(int pin,int otherpin){
	
		RobotMap.rotations = new Encoder(pin,otherpin);//This will have to change depending upon the type of encoders we use. Could also potentially change to prox. sensors but same takeaway.
		
	}
	
	public double getCount(boolean reset){
		double count;
		if(reset){
			RobotMap.rotations.reset();
		}
		count = RobotMap.rotations.get();
		//System.out.println(count);
		return count;
	}
	
	public double getDistance(){
		//Using radius and count from above get a final distance to use.
		double distance = getCount(false)/RobotMap.rotationFactor * r.circ;
		return distance;
	}
}
