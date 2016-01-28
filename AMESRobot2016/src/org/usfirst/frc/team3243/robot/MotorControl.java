package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Victor;

/**
 * This class works all the motors for the siege bot.
 * @author markvandermerwe
 *
 */
public class MotorControl {
	public static final int CARRY_IN=-1,CARRY_STOP=0,CARRY_OUT=1;
	private double ballSpeed = 0.5;
	Victor cim1 = new Victor(0);
	Victor cim2 = new Victor(1);
	Victor cim3 = new Victor(2);
	Victor cim4 = new Victor (3);
	Victor cimBall = new Victor(4);
	
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
	
	void ballCarrier(int direction){//Move this to grabber class.
		if (direction == CARRY_IN) {
			cimBall.set(-ballSpeed);
		}
		else if (direction == CARRY_OUT){
			cimBall.set(ballSpeed);
		}
		else {
			cimBall.set(0);
		}
	}
	
	public void arm(){
		
	}
	
	public void climb(){
		
	}
}
