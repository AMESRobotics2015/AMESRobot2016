package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Victor;

/**
 * This class works all the motors for the siege bot.
 * @author markvandermerwe
 *
 */
public class DriveSystem {
	public static final int CARRY_IN=-1,CARRY_STOP=0,CARRY_OUT=1;
	private double ballSpeed = 0.5;
	Victor cim1 = new Victor(0);//left front - quick
	Victor cim2 = new Victor(1);//left back - quick
	Victor cim3 = new Victor(2);//right back - quick
	Victor cim4 = new Victor (3);//right front - quick
	//Victor cimBall = new Victor(4);
	Sensors s = new Sensors();
	
	/**
	 * Our drive thing - sends the inputs we want to use into the various motors.
	 * @param drv
	 */
	void drive(double[] drv){
		cim1.set(-drv[0]);
		cim2.set(-drv[0]);
		cim3.set(drv[1]);
		cim4.set(drv[1]);
	}
	
	void moveDistance(double distance){
		/*
		while(encLeft.getDistance()<distance && encRight.getDistance()<distance){
			cim1.set(0.3);
			cim2.set(0.3);
			cim3.set(0.3);
			cim4.set(0.3);
		}
		*/
	}
	
	void rotate(double rotation){
		s.gyroFeed(true);
		if(rotation<0){
			while(s.gyroFeed(false)<rotation){
				cim1.set(-0.3);
				cim2.set(-0.3);
				cim3.set(0.3);
				cim4.set(0.3);
			}
		}else if(rotation>0){
			while(s.gyroFeed(false)<rotation){
				cim1.set(0.3);
				cim2.set(0.3);
				cim3.set(-0.3);
				cim4.set(-0.3);
			}
		}
		
	}
	
	void ballCarrier(int direction){//Move this to grabber class.
		/*
		if (direction == CARRY_IN) {
			cimBall.set(-ballSpeed);
		}
		else if (direction == CARRY_OUT){
			cimBall.set(ballSpeed);
		}
		else {
			cimBall.set(0);
		}
		*/
	}
	
	
}
