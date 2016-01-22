package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Victor;

/**
 * This class works all the motors for the siege bot.
 * @author markvandermerwe
 *
 */
public class MotorControl {
	Victor cim1 = new Victor(0);
	Victor cim2 = new Victor(1);
	Victor cim3 = new Victor(2);
	Victor cim4 = new Victor (3);
	
	/**
	 * Our drive thing - sends the inputs we want to use into the various motors.
	 * @param drv
	 */
	void drive(double[] drv){
		cim1.set(drv[1]);
		cim2.set(drv[1]);
		cim3.set(drv[0]);
		cim4.set(drv[0]);
	}
	
	/**
	 * Method for inputting values from input manager for gamepiece. NOTE: We may need to make more of these depending upon the final design.
	 */
	void gameMotor(){
		
	}
}
